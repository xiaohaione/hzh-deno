package com.hzh.hzhdeno.entity.po.modelSupport;


import com.hzh.hzhdeno.common.MsgContext;
import com.hzh.hzhdeno.common.util.StringUtil;
import com.hzh.hzhdeno.constans.ResultState;
import com.hzh.hzhdeno.entity.SysUser;
import com.hzh.hzhdeno.weixin.CoreVars;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class SysUserSupport implements IModelSupport<SysUser> {

	public SysUser get(HttpServletRequest request) {
		SysUser user = new SysUser();
		user.setSuId(StringUtil.parseInt(request.getParameter("suId")));
		user.setSuName(StringUtil.trimAndHtmlEscape(request.getParameter("userName")));
		user.setPassword(StringUtil.trim(request.getParameter("password")));
		user.setRealName(StringUtil.trimAndHtmlEscape(request.getParameter("realName")));
		user.setPhoto(StringUtil.trim(request.getParameter("photo")));
		user.setPhone(StringUtil.trimAndHtmlEscape(request.getParameter("phone")));
		user.setEmail(StringUtil.trim(request.getParameter("email")));
		user.setNickName(StringUtil.trim(request.getParameter("wxNo")));
		user.setState(StringUtil.parseInt(request.getParameter("state")));
		user.setCtrime(request.getParameter("ctrime"));
		//user.setUserName(request.getParameter("userName"));
		return user;
	}

	public MsgContext check(SysUser su, String desc, int type) {
		if (StringUtil.isEmpty(su.getSuName())) {
			return new MsgContext(ResultState.PARAM_ERROR).setDesc("请填写登录名").setName("suName");
		}
		// if(!su.getSuName().matches(Vars.RULES_UID)){
		// return new MsgContext(ResultState.PARAM_ERROR).setMessage("登录名只能输入数字、字母、下划线");
		// }
		/*
		if (type == 1) {
			if (StringUtil.isEmpty(su.getPassword())) {
				return new MsgContext(ResultState.PARAM_ERROR).setMessage("请输入登录密码").setName("password");
			}
			if (!su.getPassword().equals(password2)) {
				return new MsgContext(ResultState.PARAM_ERROR).setMessage(""管理员密码和确认密码不一致").setName("password2");
			}
		}
		*/
		if (StringUtil.isEmpty(su.getRealName())) {
			return new MsgContext(ResultState.PARAM_ERROR).setDesc("请输入管理员姓名").setName("realName");
		}
//		if (StringUtil.isNotEmpty(su.getPhoto())) {
//			if (!su.getPhoto().matches(CoreVars.RULES_URI)) {
//				return new MsgContext(ResultState.PARAM_ERROR).setDesc("照片地址不正确，如果一直重复出现该问题，请联系管理员").setName("photo");
//			}
//		}
		if (StringUtil.isNotEmpty(su.getPhone())) {
			if (!su.getPhone().matches(CoreVars.RULES_MOBILE)) {
				return new MsgContext(ResultState.PARAM_ERROR).setDesc("请输入正确的手机号码").setName("phone");
			}
		}
		if (StringUtil.isNotEmpty(su.getEmail())) {
			if (!su.getEmail().matches(CoreVars.RULES_EMAIL)) {
				return new MsgContext(ResultState.PARAM_ERROR).setDesc("请输入正确的邮箱号码").setName("email");
			}
		}
		/*if (su.getStatus() < 1 || su.getStatus() > 2) {
			return new MsgContext(ResultState.PARAM_ERROR).setMessage("管理员状态不正确").setName("status");
		}*/
		return null;
	}

}
