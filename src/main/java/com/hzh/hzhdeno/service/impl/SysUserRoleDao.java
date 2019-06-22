package com.hzh.hzhdeno.service.impl;


import com.hzh.hzhdeno.common.DaoSupport;
import com.hzh.hzhdeno.service.ISysUserRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SysUserRoleDao implements ISysUserRoleDao {
	@Autowired
	private DaoSupport daoSupportOfWrite;//默认的dao
	@Autowired
	private DaoSupport daoSupportOfRead;
//	@Autowired
//	private SysUserRoleRowmapper mapper;

	@Override
	public boolean addSysUserRole(List<Integer> roleIds, int suId) throws Exception {
		if(roleIds.size() <= 0){
			return false;
		}
		StringBuffer sql = new StringBuffer(
				"INSERT INTO sys_user_role (suId,roleId,status,ctime) VALUES");
		List<Object> params = new ArrayList<Object>();
		for (int i = 0; i < roleIds.size(); i++) {
			sql.append(" (?,?,?,NOW())");
			params.add(suId);
			params.add(roleIds.get(i));
			params.add(1);
			if (i < roleIds.size() - 1) {
				sql.append(" , ");
			}
		}
		return daoSupportOfWrite.update(sql.toString(), params.toArray()) > 0;
	}
	
//	@Override
//	public List<Integer> getSysUserRole(int suId) throws Exception {
//		String sql = "SELECT roleId FROM sys_user_role WHERE suId = ? AND `status` = 1";
//		return daoSupportOfRead.queryForIntList(sql, new Object[]{suId});
//	}
//
//	@Override
//	public boolean deleteSysUserRole(int suId, List<Integer> list) throws Exception {
//		if (list == null || list.size() <= 0) {
//			return false;
//		}
//		 String roleIdStr = "";
//		 for(int i = 0; i < list.size();i++){
//			 roleIdStr+=String.valueOf(list.get(i));
//			if (i < list.size() - 1) {
//				roleIdStr+=",";
//			}
//		 }
//		String sql =" UPDATE sys_user_role SET status = 2 WHERE suId=? AND roleId IN ("+roleIdStr+")";
//		return daoSupportOfWrite.update(sql.toString(), new Object[]{suId}) > 0;
//	}
//	/**
//	 * 功能描述: 角色是否存在用户
//	 * @auther: huangsenming
//	 * @date: 2018/7/26 10:16
//	 */
//	@Override
//	public boolean existUser(int roleId){
//		String sql = "SELECT surId FROM sys_user_role WHERE roleId=? AND STATUS=1 LIMIT 1";
//		return daoSupportOfRead.queryForExist(sql, new Object[]{roleId});
//	}
//
//	@Override
//	public boolean deleteSysUserRole(int roleId) throws Exception {
//		String sql = "UPDATE sys_user_role SET `STATUS`=2 WHERE roleId=? AND `STATUS`!=2";
//		return daoSupportOfWrite.update(sql, roleId) > 0;
//	}
//	/**
//	 * 功能描述: 根据用户id删除用户角色信息
//	 * @auther: huangsenming
//	 * @date: 2018/7/25 14:20
//	 */
//	@Override
//	public boolean deleteUserRoleBySuId(int suId) throws Exception {
//		String sql = "delete from sys_user_role where suId = ?";
//		return daoSupportOfWrite.update(sql,new Object[]{suId}) >= 0;
//	}
}
