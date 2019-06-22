package com.hzh.hzhdeno.entity.po.modelSupport;


import com.hzh.hzhdeno.common.MsgContext;
import com.hzh.hzhdeno.common.util.StringUtil;
import com.hzh.hzhdeno.constans.ResultState;
import com.hzh.hzhdeno.entity.po.SysGroup;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class SysGroupSupport implements IModelSupport<SysGroup> {

	public SysGroup get(HttpServletRequest request) {
		SysGroup sysGroup = new SysGroup();
		sysGroup.setGroupId(StringUtil.parseInt(request.getParameter("groupId")));
		sysGroup.setGroupName(StringUtil.trimAndHtmlEscape(request.getParameter("groupName")));
		sysGroup.setParentId(StringUtil.parseInt(request.getParameter("parentId")));
		sysGroup.setGroupPic(StringUtil.trim(request.getParameter("groupPic")));
		sysGroup.setAddress(StringUtil.trimAndHtmlEscape(request.getParameter("address")));
		sysGroup.setLeader(StringUtil.trimAndHtmlEscape(request.getParameter("leader")));
		sysGroup.setPhone(StringUtil.trimAndHtmlEscape(request.getParameter("phone")));
		sysGroup.setGroupPhone(StringUtil.trimAndHtmlEscape(request.getParameter("groupPhone")));
		sysGroup.setGroupStatus(StringUtil.parseInt(request.getParameter("groupStatus")));
		return sysGroup;
	}

	public MsgContext check(SysGroup model, String desc, int type) {
		if (type == 2 && model.getGroupId() <= 0) {
			return new MsgContext(ResultState.REQUEST_ILLEGAL).setName("groupId");
		}
		if(StringUtil.isEmpty(model.getGroupName())){
			return new MsgContext(ResultState.PARAM_ERROR).setDesc("机构名称不能为空").setName("groupName");
		}
		return null;
	}

}
