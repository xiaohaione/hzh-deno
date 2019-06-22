package com.hzh.hzhdeno.entity.po;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class SysRole implements Serializable {
	private static final long serialVersionUID = 1L;
	private int roleId; // 系统角色ID
	private int groupId; // 机构ID
	private int roleType; // 角色类型1、普通角色，2、机构管理员角色
	private String roleName; // 角色名称
	private int sort; // 角色优先级，数字越大优先级越高
	private int status; // 角色状态：1启用，2禁用，3删除
	private String ctime; // 添加时间

}
