package com.hzh.hzhdeno.entity.po.modelSupport;


import com.hzh.hzhdeno.common.MsgContext;
import com.hzh.hzhdeno.common.util.StringUtil;
import com.hzh.hzhdeno.constans.ResultState;
import com.hzh.hzhdeno.entity.po.SysMenu;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class SysMenuSupport implements IModelSupport<SysMenu>{
	
	public SysMenu get(HttpServletRequest request) {
		SysMenu menu = new SysMenu();
		menu.setMenuId(StringUtil.parseInt(request.getParameter("menuId")));
		menu.setMenuName(StringUtil.trimAndHtmlEscape(request.getParameter("menuName")));
		menu.setNodeKey(StringUtil.trimAndHtmlEscape(request.getParameter("nodeKey")));
		/*menu.setUrl(StringUtil.trim(request.getParameter("url")));*/
		menu.setParentId(StringUtil.parseInt(request.getParameter("parentId")));
		menu.setMenuStatus(StringUtil.parseInt(request.getParameter("menuStatus")));
		menu.setLabel(StringUtil.trimAndHtmlEscape(request.getParameter("label")));
		menu.setSort(StringUtil.parseInt(request.getParameter("sort")));
		menu.setMenuPic(StringUtil.trim(request.getParameter("menuPic")));
		menu.setCtime(StringUtil.trim(request.getParameter("ctime")));
		return menu;
	}

	public MsgContext check(SysMenu model, String desc, int type) {
		if (type == 2 && model.getMenuId() <= 0) {
			return new MsgContext(ResultState.REQUEST_ILLEGAL).setDesc("密码错误").setName("menuId");
		}
		if(StringUtil.isEmpty(model.getMenuName())){
			return new MsgContext(ResultState.PARAM_ERROR).setDesc("菜单名称不能为空").setName("menuName");
		}
		if(StringUtil.isEmpty(model.getNodeKey())){
			return new MsgContext(ResultState.PARAM_ERROR).setDesc("请选择节点").setName("nodeKey");
		}
		if(model.getMenuStatus() <= 0){
			return new MsgContext(ResultState.PARAM_ERROR).setDesc("请选择菜单状态").setName("menuStatus");
		}
		if(model.getSort() <= 0){
			return new MsgContext(ResultState.PARAM_ERROR).setDesc("菜单排序序号不能为空").setName("sort");
		}
		return null;
	}

}
