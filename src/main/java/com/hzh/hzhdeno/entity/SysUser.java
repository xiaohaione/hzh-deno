package com.hzh.hzhdeno.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@ApiModel(value="User", description = "平台管理用户")
public class SysUser implements Serializable {

	private static final long serialVersionUID = 1L;
    @ApiModelProperty("主键")
	private int suId; // 系统用户ID

    @ApiModelProperty("用户名")
	private String suName; // 账号
//	@ApiModelProperty("登录名")
//	private String userName; // 防止添加的时候被登录用户的用户名覆盖

    @ApiModelProperty("密码")
	private String password; // 密码

    @ApiModelProperty("用户类型：1：普通，2-机构，3-系统")
	private int roleType; // 用户类型：1：普通，2-机构，3-系统

    @ApiModelProperty("真实姓名")
	private String realName; // 真实姓名

    @ApiModelProperty("头像")
	private String photo; // 头像

    @ApiModelProperty("电话号码")
	private String phone; // 电话号码

    @ApiModelProperty("邮箱")
	private String email; // 邮箱

//    @ApiModelProperty("潮生活授权Id")
//	private String oauthId; // 潮生活授权Id
    @ApiModelProperty("微信号昵称")
	private String nickName; // 微信号昵称

    @ApiModelProperty("openId")
	private String openId; // openId

    @ApiModelProperty("状态：1：可用，2：禁用，3：删除状态")
	private int state; // 状态：1：可用，2：禁用，3：删除状态
//
    @ApiModelProperty("创建时间")
	private String ctrime; // 创建时间
//
//	private String roleName;//角色名称
//
//	private String groupName;//部门名称
//
//	private int roleId;//角色id
//
//	private int groupId;//部门id

}
