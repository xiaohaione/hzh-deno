package com.hzh.hzhdeno.entity.po.modelSupport;


import com.hzh.hzhdeno.common.MsgContext;
import com.hzh.hzhdeno.common.util.StringUtil;
import com.hzh.hzhdeno.constans.ResultState;
import com.hzh.hzhdeno.entity.po.SysRole;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * create by: hezhihai
 * description: TODO
 * create time: 2019/4/26 11:31
 */
@Component
public class SysRoleSupport implements IModelSupport<SysRole> {

    public SysRole get(HttpServletRequest request) {
        SysRole role = new SysRole();
        role.setRoleName(StringUtil.trimAndHtmlEscape(request.getParameter("roleName")));
        role.setStatus(StringUtil.parseInt(request.getParameter("status")));
        role.setGroupId(StringUtil.parseInt(request.getParameter("groupId")));
        role.setRoleType(StringUtil.parseInt(request.getParameter("roleType")));
        return role;
    }

    public MsgContext check(SysRole role, String desc, int type) {
        if (type == 2 && role.getRoleId() <= 0) {
            return new MsgContext(ResultState.REQUEST_ILLEGAL);
        }
        if (StringUtil.isEmpty(role.getRoleName())) {
            return new MsgContext(ResultState.PARAM_ERROR).setDesc("请输入角色名称").setName("roleName");
        }
        if (role.getGroupId() <= 0) {
            return new MsgContext(ResultState.PARAM_ERROR).setDesc("请选择机构").setName("groupId");
        }
//		if(role.getStatus() <= 0){
//			return new MsgContext(ResultState.PARAM_ERROR).setDesc("请输入角色状态").setName("status");
//		}
//		if(role.getRoleType() != 1 && role.getRoleType() != 2){
//			return new MsgContext(ResultState.PARAM_ERROR).setDesc("请选择角色类型").setName("roleType");
//		}
        return null;
    }

}
