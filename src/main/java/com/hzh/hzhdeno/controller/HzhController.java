package com.hzh.hzhdeno.controller;

import com.hzh.hzhdeno.annotion.AssemblyMethod;
import com.hzh.hzhdeno.annotion.ExcludeMapping;
import com.hzh.hzhdeno.common.ControllerContext;
import com.hzh.hzhdeno.common.DaoSupport;
import com.hzh.hzhdeno.common.MsgContext;
import com.hzh.hzhdeno.common.redis.model.LoginUser;
import com.hzh.hzhdeno.common.util.DateUtil;
import com.hzh.hzhdeno.common.util.EncryptUtil;
import com.hzh.hzhdeno.common.util.SignUtil;
import com.hzh.hzhdeno.common.util.StringUtil;
import com.hzh.hzhdeno.constans.OperateEnums;
import com.hzh.hzhdeno.constans.ResultState;
import com.hzh.hzhdeno.entity.SysUser;
import com.hzh.hzhdeno.entity.bo.HzhBO;
import com.hzh.hzhdeno.entity.hzhVO;
import com.hzh.hzhdeno.entity.po.modelSupport.IModelSupport;
import com.hzh.hzhdeno.service.ISysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/hzh/index")
//@Api(value = "区域信息", tags = {"RESTFUL接口"})
public class HzhController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private IModelSupport<SysUser> sysUserSupport;

    @Autowired
    private DaoSupport daoSupportOfWrite;
    @Autowired
    private DaoSupport daoSupportOfRead;

    @Autowired
    private ISysUserService sysUserService;

    @PostMapping("/updateState")
//    @ApiOperation(value = "updateState", notes = "禁用/启用状态")
    @AssemblyMethod(operateEnums = OperateEnums.BUSINESS_LABEL_INDEX, name = "首页", entrance = true)
    public MsgContext updateState(@RequestBody hzhVO hzhVO) {
        String sql = "select cityId , cityName from city where cityId = ?";
        Object[] param = {hzhVO.getCityId()};
        BeanPropertyRowMapper<HzhBO> rowMapper = new BeanPropertyRowMapper(HzhBO.class);
        logger.error("a:" + daoSupportOfRead.query(sql, param, rowMapper));
        return new MsgContext(ResultState.SUCCESS).setInfo(daoSupportOfRead.query(sql, param, rowMapper));
    }

    /**
     * 登录
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    @AssemblyMethod(operateEnums = OperateEnums.HOME_INDEX, name = "首页", entrance = true, nodeType = 2)
    @ExcludeMapping //这个注解是指绕过过滤器的拦截请求
    @ResponseBody
    public MsgContext login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (StringUtil.isEmpty(username)) {
            return new MsgContext(ResultState.PARAM_ERROR_EMP).setDesc("用户名不能为空").setName("username");
        }
        if (StringUtil.isEmpty(password)) {
            return new MsgContext(ResultState.PARAM_ERROR_EMP).setDesc("密码不能为空").setName("password");
        }
        SysUser su;
        try {
            su = sysUserService.getSysUser(username);
        } catch (Exception e) {
            logger.error(e.toString());
            return new MsgContext(0).setInfo(null).setDesc("获取用户失敗");
        }
        if (su == null || su.getState() < 0 || su.getState() > 2) {
            return new MsgContext(ResultState.PARAM_ERROR_EMP).setDesc("用户不存在").setName("username");
        }
        if (su.getState() != 1) {
            return new MsgContext(ResultState.PARAM_ERROR_EMP).setDesc("用户已经被禁用").setName("username");
        }
        password = EncryptUtil.md5(password);

        if (!password.equalsIgnoreCase(su.getPassword())) {
            return new MsgContext(ResultState.PARAM_ERROR_EMP).setDesc("密码错误").setName("password");
        }
        //不是超级管理员,检查是否被禁用,角色,部门等
        if (2 != su.getRoleType() && !sysUserService.checkUser(username)) {
            return new MsgContext(0).setInfo(null).setDesc("用户账号异常,请联系管理员");
        }
        Map<String, String> params = new HashMap<String, String>();
        params.put("userName", username);
        params.put("password", password);
        params.put("date", DateUtil.today());
        params.put("userAgent", request.getHeader("user-agent"));
        params.put("ip", ControllerContext.getIp(request));
        String token = SignUtil.sign(params, password);
        LoginUser loginUser = new LoginUser();
        loginUser.setSysUser(su);
        loginUser.setToken(token);
        //登录成功
//        loginUserCache.removeUser(username);//先删除之前的再添加替换
//        loginUserCache.setUser(username, loginUser);
        Map<String, Object> info = new HashMap<>();
        info.put("token", token);
        info.put("loginUser", loginUser);
        return new MsgContext(1).setInfo(info);
    }

    /**
     * 新增用户
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/create")
    @AssemblyMethod(operateEnums = OperateEnums.USER_INDEX, name = "首页", entrance = true)
//    @ApiOperation(value = "/create", notes = "用户创建", response = MsgContext.class)
    @ResponseBody
    public MsgContext create(HttpServletRequest request, @RequestBody SysUser su) {
//        //校验输入用户参数
//        SysUser su = sysUserSupport.get(request);
//        MsgContext msgContext = sysUserSupport.check(su, "创建管理员", 1);
//        if (msgContext != null && msgContext.isState() == 0) {
//            return msgContext;
//        }
        if (StringUtil.isEmpty(su.getPassword())) {
            return new MsgContext(ResultState.PARAM_ERROR).setDesc("请输入登录密码").setName("password");
        }
//        String[] roleIds = request.getParameterValues("roleId");
        String[] roleIds = {};
        try {
            return sysUserService.createSysUser(su);
        } catch (Exception e) {
            logger.error(e.toString());
            return new MsgContext(0).setInfo(null).setDesc("创建失敗");
        }
    }
}
