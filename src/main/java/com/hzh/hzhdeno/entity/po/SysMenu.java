package com.hzh.hzhdeno.entity.po;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ApiModel(value="Menu", description = "平台管理菜单")
public class SysMenu implements Serializable {
	private static final long serialVersionUID = 1L;
	private int menuId; // 系统角色ID
	private String menuName; // 菜单名称
	private String nodeKey; // 节点key
	private String menuEnum; // 菜单栏
	private String url; // 菜单匹配的路径
	private int parentId; // 父级菜单ID
	private int menuStatus; // 状态：1 启用，2：禁用，3：删除
	private String label; // 权限标签
	private int sort; // 排序序号
	private String menuPic; // 菜单相对应的图片
	private String ctime; // 创建时间
	
	private List<SysMenu> childMenuList;
	
	private boolean hasQx; // 存在权限

}
