package com.hzh.hzhdeno.entity.po;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ApiModel(value="Group", description = "平台管理组织")
public class SysGroup implements Serializable {
	private static final long serialVersionUID = 1L;
	private int groupId; // 系统部门ID
	private String groupName; // 部门名称
	private int parentId; // 上级部门
	private String groupPic; // 部门图片
	private String address; // 部门地址
	private String leader; // 部门负责人
	private String phone; // 负责人电话
	private String groupPhone; // 部门电话
	private int groupStatus; // 状态：1:启用，2：禁用，3：删除
	private String sn; // 唯一编码
	private String ctime; // 创建时间
	
	private List<SysGroup> childGroupList; // 子级

}
