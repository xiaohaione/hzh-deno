package com.hzh.hzhdeno.service;

import java.util.List;

public interface ISysUserRoleDao {

	/**
	 * 
	 * @Title: addSysUserRole
	 * @Description: 添加用户角色信息
	 * @param  roleIds  需要添加的角色集合
	 * @param  suId 需要添加的用户ID
	 * @return boolean    true-添加成功，false-添加失败
	 */
	public boolean addSysUserRole(List<Integer> roleIds, int suId) throws Exception;
//	/**
//	 *
//	 * @Title: getSysUserRole
//	 * @Description: 根据用户ID获取角色ID集合
//	 * @param  suId 需要获取角色的用户ID
//	 * @return List<Integer>   返回根据用户ID获得的角色信息{@link SysUserRole}角色ID集合
//	 */
//	public List<Integer> getSysUserRole(int suId) throws Exception;
//	/**
//	 * 批量删除用户权限关联
//	 *
//	 * @param suId 用户Id
//	 * @param list 角色Id集合
//	 * @return boolean
//	 * @author 创建人：ylb
//	 * @date 创建时间：2017-6-27 上午11:12:16
//	 */
//	public boolean deleteSysUserRole(int suId, List<Integer> list) throws Exception;
//	/**
//	 * 判断是否存在权限
//	 *
//	 * @param roleId 角色Id
//	 * @return boolean
//	 * @author 创建人：ylb
//	 * @date 创建时间：2017-7-5 下午4:17:45
//	 */
//	boolean existUser(int roleId);
//	/**
//	 * 根据角色Id禁用权限
//	 *
//	 * @param roleId 角色Id
//	 * @return boolean
//	 * @author 创建人：ylb
//	 * @date 创建时间：2017-7-5 下午4:18:16
//	 */
//	boolean deleteSysUserRole(int roleId) throws Exception;
//	/**
//	 * 功能描述: 根据用户id删除用户角色信息
//	 * @auther: huangsenming
//	 * @date: 2018/7/25 14:20
//	 */
//	boolean deleteUserRoleBySuId(int suId) throws Exception;
}
