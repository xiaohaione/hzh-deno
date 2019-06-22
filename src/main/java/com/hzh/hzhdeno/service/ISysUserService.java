package com.hzh.hzhdeno.service;



import com.hzh.hzhdeno.common.MsgContext;
import com.hzh.hzhdeno.entity.SysUser;

import java.util.Map;


public interface ISysUserService {

	/**
	 * 
	 * @Title: getSysUser
	 * @Description: 根据用户名称查询用户信息包括部门名称
	 * @param  suName 用户名称
	 * @return SysUserExpand  返回获得的用户信息{@link SysUser}
	 */
	public SysUser getSysUser(String suName) throws Exception;
//	/**
//	 *
//	 * @Title: updatePassword
//	 * @Description: 根据用户名称和ID 更新密码
//	 * @param  suId 需要更新的用户ID
//	 * @param  password 需要更新的密码
//	 * @return MsgContext    true-更新成功，false-更新失败
//	 */
//	//public MsgContext updatePassword(SysUser su, int suId, String suName, String password) throws Exception;
//	public MsgContext updatePassword(int suId, String password) throws Exception;
	/**
	 *
	 * @Title: createSysUser
	 * @Description: 添加管理员
	 * @param  su 需要添加的管理员信息
	 * @return MsgContext
	 */
//	 MsgContext createSysUser(SysUser su, String[] roleIds) throws Exception;
	MsgContext createSysUser(SysUser su) throws Exception;
//	/**
//	 *
//	 * @Title: getSysUser
//	 * @Description: 根据用户ID获取用户信息
//	 * @param  suId 用户ID
//	 * @return SysUserExpand    返回获得的用户信息{@link SysUser}
//	 */
//	public SysUser getSysUser(int suId) throws Exception;
//	/**
//	 *
//	 * @Title: updateStatus
//	 * @Description: 根据用户ID和名称更新状态
//	 * @param  suId 需要更新的用户ID
//	 * @param  state 需要更新的状态
//	 * @return MsgContext    true-更新成功，false-更新失败
//	 */
//	public MsgContext updateStatus(int suId, int state) throws Exception;
//	/**
//	 *
//	 * @Title: deleteSysUser
//	 * @Description: 根据用户ID和名称删除用户
//	 * @param  suId 用户ID
//	 * @return MsgContext    true-删除成功，false-删除失败
//	 */
//	public MsgContext deleteSysUser(int suId) throws Exception;
//
//	/**
//	 * 功能描述: 根据用户名模糊查询用户列表
//	 * @auther: huangsenming
//	 * @date: 2018/7/25 13:26
//	 */
//	Map<String, Object> getUserList(Page page, String realName, int roleId);
//	/**
//	 * 功能描述: 更新用户信息
//	 * @auther: huangsenming
//	 * @date: 2018/7/25 14:08
//	 */
//	MsgContext updateSysUser(SysUser user, String[] roleIds);
//	/**
//	 * 功能描述: 检查用户角色,部门状态是否征程
//	 * @auther: huangsenming
//	 * @date: 2018/8/1 14:05
//	 */
	boolean checkUser(String suName);


}
