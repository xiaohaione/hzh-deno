package com.hzh.hzhdeno.dao.impl;


import com.hzh.hzhdeno.common.DaoSupport;
import com.hzh.hzhdeno.dao.ISysUserDao;
import com.hzh.hzhdeno.dao.rowmapper.SysUserRowmapper;
import com.hzh.hzhdeno.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class SysUserDao implements ISysUserDao {
    @Autowired
    private DaoSupport daoSupportOfWrite;//默认的dao
    @Autowired
    private DaoSupport daoSupportOfRead;
    @Autowired
    private SysUserRowmapper mapper;

//	@Autowired
//	private SysUserRowmapperBO mapperBO;

    /**
     * @param suName 用户名称
     * @return
     * @throws Exception
     */
    @Override
    public SysUser getUserBySuName(String suName) throws Exception {
        String sql = "SELECT * FROM sys_user WHERE suName = ? AND status <3 LIMIT 1";
        return daoSupportOfRead.queryForObject(sql, new Object[]{suName}, mapper);
    }

    /**
     * @param suName 需要查询用户{@link SysUser}的用户名
     * @return
     * @throws Exception
     */
    @Override
    public int getSuIdBySuName(String suName) throws Exception {
        String sql = "SELECT suId FROM sys_user WHERE suName=? AND status<3";
        Object[] params = new Object[]{suName};
        return daoSupportOfRead.queryForInt(sql, params);
    }

    /**
     * @param su 需要添加的管理员信息
     * @return
     * @throws Exception
     */
    @Override
    public int createUser(SysUser su) throws Exception {
        String sql = "INSERT INTO sys_user(suName,password,status,realName,roleType,"
                + "photo,phone,email,nickName,openId,ctime) VALUES (?,?,1,?,?,?,?,?,?,?,NOW())";
        Object[] params = new Object[]{su.getSuName(), su.getPassword(), su.getRealName(), su.getRoleType(),
                su.getPhoto(), su.getPhone(), su.getEmail(), su.getNickName(), su.getOpenId()};
        su.setSuId(daoSupportOfWrite.insert(sql, params));
        return su.getSuId();
    }

//	@Override
//	public boolean updatePassword(int suId,  String password) throws Exception {
//		String sql = "UPDATE sys_user SET password=? WHERE suId=? LIMIT 1 ";
//		Object[] params = new Object[]{password, suId};
//		return daoSupportOfWrite.update(sql, params)>=0;
//	}
//
//	@Override
//	public boolean updateRealName(SysUser su) throws Exception {
//		String sql = "UPDATE sys_user SET realName=?,photo=?,phone=?,email=?,nickName=? where suId=? and suName=? LIMIT 1";
//		Object[] params = new Object[]{su.getRealName(),su.getPhoto(),su.getPhone(),su.getEmail(),su.getNickNmae(),
//				su.getSuId(), su.getSuName()};
//		return daoSupportOfWrite.update(sql, params)>=0;
//	}
//
////	@Override
////	public List<SysUser> getUserList(Page page, SysUser su, int groupId, int roleId) throws Exception {
////		List<Object> params = new ArrayList<Object>();
////		StringBuilder sql = new StringBuilder();
////		sql.append("SELECT COUNT(1) FROM (SELECT DISTINCT t1.suId FROM sys_user t1 ");
////		sql.append("LEFT JOIN (SELECT * FROM sys_user_role WHERE status=1) t2 ON t1.suId=t2.suId ");
////		sql.append("LEFT JOIN sys_role t3 ON t2.roleId=t3.roleId ");
////		sql.append("WHERE t1.status<=2");
////		if(groupId > 0){
////			sql.append(" AND t3.groupId=?");
////			params.add(groupId);
////		}
////		if(roleId > 0){
////			sql.append(" AND t2.roleId=?");
////			params.add(roleId);
////		}
////		if(StringUtil.isNotEmpty(su.getSuName())){
////			sql.append(" AND suName like ?");
////			params.add(StringUtil.toLikeStr(su.getSuName()));
////		}
////		if(StringUtil.isNotEmpty(su.getRealName())){
////			sql.append(" AND realName like ?");
////			params.add(StringUtil.toLikeStr(su.getRealName()));
////		}
////		if(StringUtil.isNotEmpty(su.getPhone())){
////			sql.append(" AND phone like ?");
////			params.add(StringUtil.toLikeStr(su.getPhone()));
////		}
////
////		if(StringUtil.isNotEmpty(su.getEmail())){
////			sql.append(" AND email like ?");
////			params.add(StringUtil.toLikeStr(su.getEmail()));
////		}
////		if(su.getStatus()>0){
////			sql.append(" AND t1.status = ?");
////			params.add(su.getStatus());
////		}
////		sql.append(")a");
////		page.setTotalSize(daoSupportOfRead.queryForInt(sql.toString(), params.toArray()));
////		if(page.getTotalSize()<=0){
////			return null;
////		}
////		sql = new StringBuilder();
////		sql.append("SELECT DISTINCT t1.* FROM sys_user t1 ");
////		sql.append("LEFT JOIN (SELECT * FROM sys_user_role WHERE status=1) t2 ON t1.suId=t2.suId ");
////		sql.append("LEFT JOIN sys_role t3 ON t2.roleId=t3.roleId ");
////		sql.append("WHERE t1.status <=2");
////		if(groupId > 0){
////			sql.append(" AND t3.groupId=?");
////		}
////		if(roleId > 0){
////			sql.append(" AND t2.roleId=?");
////		}
////		if(StringUtil.isNotEmpty(su.getSuName())){
////			sql.append(" AND suName like ?");
////		}
////		if(StringUtil.isNotEmpty(su.getRealName())){
////			sql.append(" AND realName like ?");
////		}
////		if(StringUtil.isNotEmpty(su.getPhone())){
////			sql.append(" AND phone like ?");
////		}
////
////		if(StringUtil.isNotEmpty(su.getEmail())){
////			sql.append(" AND email like ?");
////		}
////		if(su.getStatus()>0){
////			sql.append(" AND t1.status = ?");
////		}
////
////		if(StringUtil.isNotEmpty(page.getOrderBy())){
////			sql.append(" ORDER BY ").append(page.getOrderBy()).append(" ").append(page.getOrderType())
////				.append(",t1.suId ").append(page.getOrderType());
////		}else{
////			sql.append(" ORDER BY t1.suId");
////		}
////		sql.append(" LIMIT ?,?");
////		params.add(page.getCursor());
////		params.add(page.getPerSize());
////		return  daoSupportOfRead.query(sql.toString(), params.toArray(), mapper);
////	}
//
//	@Override
//	public List<SysUser> getUserList(Page page, SysUser su, int groupId, int roleId,String realName) throws Exception {
//		List<Object> params = new ArrayList<Object>();
//		StringBuilder sql = new StringBuilder();
//		sql.append("select t1.*,t3.roleName,t4.groupName,t3.roleId,t4.groupId \n" +
//				"from sys_user t1 \n" +
//				"LEFT JOIN sys_user_role t2 ON t1.suId=t2.suId\n" +
//				"LEFT JOIN sys_role t3 ON t2.roleId=t3.roleId \n" +
//				"LEFT JOIN sys_group t4 ON t4.groupId=t3.groupId \n" +
//				"WHERE t1.realName != '超级管理员' and t1.status != 3 and t2.status = 1");
//		if (StringUtil.isNotEmpty(realName)) {
//			sql.append(" and realName like ? ");
//			params.add(StringUtil.toLikeStr(realName));
//		}
////		if(){
////
////		}
//		sql.append( " limit ?,?");
//		params.add((page.getPage() - 1) * page.getPerSize());
//		params.add(page.getPerSize());
//		return daoSupportOfRead.query(sql.toString(), params.toArray(), mapperBO);
//	}
//
//	@Override
//	public int getSuIdBySuName(String suName) throws Exception {
//		String sql = "SELECT suId FROM sys_user WHERE suName=? AND status<3";
//		Object[] params = new Object[]{suName};
//		return daoSupportOfRead.queryForInt(sql, params);
//	}
//
//	@Override
//	public int createUser(SysUser su) throws Exception {
//		String sql = "INSERT INTO sys_user(suName,password,status,realName,roleType,"
//				+ "photo,phone,email,nickName,openId,ctime) VALUES (?,?,1,?,?,?,?,?,?,?,NOW())";
//		Object[] params = new Object[]{su.getSuName(), su.getPassword(),su.getRealName(), su.getRoleType(),
//				su.getPhoto(), su.getPhone(), su.getEmail(), su.getNickNmae(),su.getOpenId()};
//		su.setSuId(daoSupportOfWrite.insert(sql, params));
//		return su.getSuId();
//	}
//
//	@Override
//	public SysUser getUser(int suId){
//		String sql = "SELECT * FROM sys_user WHERE suId=? AND STATUS!=3 LIMIT 1";
//		Object[] params = new Object[]{suId};
//		return daoSupportOfRead.queryForObject(sql, params, mapper);
//	}
//
//	@Override
//	public boolean updateUser(SysUser su) throws Exception {
//		String sql = "UPDATE sys_user SET realName=?,suName=?,"
//				+ "photo=?,phone=?,email=?,ctime=NOW() where suId=? ";
//		Object[] params = new Object[]{
//				su.getRealName(),su.getSuName(),
//				su.getPhoto(),su.getPhone(),su.getEmail(), su.getSuId()
//		};
//		return daoSupportOfWrite.update(sql, params)>0;
//	}
//
//	@Override
//	public boolean updateStatus(int suId, int state) throws Exception {
//		String sql = "UPDATE sys_user SET status=? WHERE suId=? LIMIT 1";
//		Object[] params = new Object[]{state, suId};
//		return daoSupportOfWrite.update(sql, params)>=0;
//	}
//
//	@Override
//	public boolean deleteUser(int suId) throws Exception {
//		String sql = "UPDATE sys_user SET status=3 WHERE suId=? LIMIT 1";
//		Object[] params = new Object[]{suId};
//		return daoSupportOfWrite.update(sql, params)>0;
//	}
//
//	@Override
//	public List<SysUser> getSysUserList(Page page, SysUser su, List<Integer> groupIdList, int roleId) throws Exception {
//		if(groupIdList == null || groupIdList.size() <= 0){
//			return null;
//		}
//		StringBuilder str = new StringBuilder();
//		for(int i=0;i<groupIdList.size();i++){
//			str.append(groupIdList.get(i));
//			if(i < groupIdList.size()-1){
//				str.append(",");
//			}
//		}
//		List<Object> params = new ArrayList<Object>();
//		StringBuilder sql = new StringBuilder();
//		sql.append("SELECT COUNT(1) FROM (SELECT DISTINCT t1.* FROM sys_user t1 ");
//		sql.append("LEFT JOIN sys_user_role t2 ON t1.suId=t2.suId ");
//		sql.append("LEFT JOIN sys_role t3 ON t2.roleId=t3.roleId ");
//		sql.append("WHERE t1.status<3 AND t2.status=1 AND t3.status=1 AND t3.groupId IN (");
//		sql.append(str).append(")");
//		if(roleId > 0){
//			sql.append(" AND t2.roleId=?");
//			params.add(roleId);
//		}
//		if(StringUtil.isNotEmpty(su.getSuName())){
//			sql.append(" AND suName like ?");
//			params.add(StringUtil.toLikeStr(su.getSuName()));
//		}
//		if(StringUtil.isNotEmpty(su.getRealName())){
//			sql.append(" AND realName like ?");
//			params.add(StringUtil.toLikeStr(su.getRealName()));
//		}
//		if(StringUtil.isNotEmpty(su.getPhone())){
//			sql.append(" AND phone like ?");
//			params.add(StringUtil.toLikeStr(su.getPhone()));
//		}
//
//		if(StringUtil.isNotEmpty(su.getEmail())){
//			sql.append(" AND email like ?");
//			params.add(StringUtil.toLikeStr(su.getEmail()));
//		}
//		if(su.getStatus()>0){
//			sql.append(" AND t1.status = ?");
//			params.add(su.getStatus());
//		}
//		sql.append(") a");
//		page.setTotalSize(daoSupportOfRead.queryForInt(sql.toString(), params.toArray()));
//		if(page.getTotalSize()<=0){
//			return null;
//		}
//		sql = new StringBuilder();
//		sql.append("SELECT DISTINCT t1.*,t3.roleName,t4.groupName,t3.roleId,t4.goupId FROM sys_user t1 ");
//		sql.append("LEFT JOIN sys_user_role t2 ON t1.suId=t2.suId ");
//		sql.append("LEFT JOIN sys_role t3 ON t2.roleId=t3.roleId ");
//		sql.append("LEFT JOIN sys_group t4 ON t4.groupId=t3.groupId ");
//		sql.append("WHERE t1.status<3 AND t2.status=1 AND t3.status=1 AND t3.groupId IN (");
//		sql.append(str).append(")");
//		if(roleId > 0){
//			sql.append(" AND t2.roleId=?");
//		}
//		if(StringUtil.isNotEmpty(su.getSuName())){
//			sql.append(" AND suName like ?");
//		}
//		if(StringUtil.isNotEmpty(su.getRealName())){
//			sql.append(" AND realName like ?");
//		}
//		if(StringUtil.isNotEmpty(su.getPhone())){
//			sql.append(" AND phone like ?");
//		}
//
//		if(StringUtil.isNotEmpty(su.getEmail())){
//			sql.append(" AND email like ?");
//		}
//		if(su.getStatus()>0){
//			sql.append(" AND t1.status = ?");
//		}
//
//		if(StringUtil.isNotEmpty(page.getOrderBy())){
//			sql.append(" ORDER BY ").append(page.getOrderBy()).append(" ").append(page.getOrderType())
//				.append(",suId ").append(page.getOrderType());
//		}else{
//			sql.append(" ORDER BY suId");
//		}
//		sql.append(" LIMIT ?,?");
//		params.add(page.getCursor());
//		params.add(page.getPerSize());
//		return  daoSupportOfRead.query(sql.toString(), params.toArray(), mapperBO);
//	}
//
//	@Override
//	public List<Map<String, Object>> getSysUserListByGroupId(int groupId) throws Exception {
//		String sql = "SELECT t3.suId,t3.suName FROM sys_role t1 "
//			+"LEFT JOIN sys_user_role t2 ON t1.roleId=t2.roleId "
//			+"LEFT JOIN sys_user t3 ON t2.suId=t3.suId "
//			+"LEFT JOIN city_manager t4 ON t3.suId=t4.suId "
//			+"WHERE t1.groupId=? AND t1.status=1 AND t2.status=1 AND t3.status=1 AND t4.cmgId IS null";
//		return daoSupportOfRead.queryForList(sql, groupId);
//	}
//
//	@Override
//	public List<Map<String, Object>> getAllSysUserByGroupId(int groupId) throws Exception {
//		String sql = "SELECT t3.suId,t3.suName FROM sys_role t1 "
//				+ "LEFT JOIN sys_user_role t2 ON t1.roleId=t2.roleId "
//				+ "LEFT JOIN sys_user t3 ON t2.suId=t3.suId "
//				+ "WHERE t1.groupId=? AND t1.status=1 AND t2.status=1 AND t3.status=1";
//		return daoSupportOfRead.queryForList(sql, groupId);
//	}
//
//	@Override
//	public Map<String, Object> getSysUserType(int suId) throws Exception {
//		String sql = "SELECT t3.roleType,t1.roleType AS userType,t4.sn FROM sys_user t1 "
//				+ "LEFT JOIN sys_user_role t2 ON t1.suId=t2.suId "
//				+ "LEFT JOIN sys_role t3 ON t3.roleId=t2.roleId "
//				+ "LEFT JOIN sys_group t4 ON t4.groupId=t3.groupId "
//				+ "WHERE t1.suId=? AND (t1.roleType=2 OR (t2.status=1 AND t3.status=1 AND t4.groupStatus=1))";
//		return daoSupportOfRead.queryForMap(sql, suId);
//	}
//
//	@Override
//	public SysUser getUserByOpenId(String openId) {
//		String sql = "SELECT * FROM sys_user WHERE openId=?;";
//		return daoSupportOfRead.queryForObject(sql,new Object[]{openId},mapper);
//	}
//
//	@Override
//	public int getUserListTotal(Page page, SysUser su, int groupId, int roleId, String realName) {
//		List<Object> params = new ArrayList<Object>();
//		StringBuilder sql = new StringBuilder();
//		sql.append("select count(1) \n" +
//				"from sys_user t1 \n" +
//				"LEFT JOIN sys_user_role t2 ON t1.suId=t2.suId\n" +
//				"LEFT JOIN sys_role t3 ON t2.roleId=t3.roleId \n" +
//				"LEFT JOIN sys_group t4 ON t4.groupId=t3.groupId "+
//		"WHERE t1.realName != '超级管理员' and t1.status != 3 and t2.status = 1");
//		if (StringUtil.isNotEmpty(realName)) {
//			sql.append(" and realName like ? ");
//			params.add(StringUtil.toLikeStr(realName));
//		}
//		return daoSupportOfRead.queryForInt(sql.toString(), params.toArray());
//	}
//
//	@Override
//	public int getUserListTotal2(Page page, SysUser su, List<Integer> groupIdList, int roleId) {
//		if(groupIdList == null || groupIdList.size() <= 0){
//			return 0;
//		}
//		StringBuilder str = new StringBuilder();
//		for(int i=0;i<groupIdList.size();i++){
//			str.append(groupIdList.get(i));
//			if(i < groupIdList.size()-1){
//				str.append(",");
//			}
//		}
//		List<Object> params = new ArrayList<Object>();
//		StringBuilder sql = new StringBuilder();
//		sql.append("SELECT COUNT(1) FROM (SELECT DISTINCT t1.* FROM sys_user t1 ");
//		sql.append("LEFT JOIN sys_user_role t2 ON t1.suId=t2.suId ");
//		sql.append("LEFT JOIN sys_role t3 ON t2.roleId=t3.roleId ");
//		sql.append("WHERE t1.status<3 AND t2.status=1 AND t3.status=1 AND t3.groupId IN (");
//		sql.append(str).append(")");
//		if(roleId > 0){
//			sql.append(" AND t2.roleId=? ");
//			params.add(roleId);
//		}
//		if(StringUtil.isNotEmpty(su.getSuName())){
//			sql.append(" AND suName like ?");
//			params.add(StringUtil.toLikeStr(su.getSuName()));
//		}
//		if(StringUtil.isNotEmpty(su.getRealName())){
//			sql.append(" AND realName like ?");
//			params.add(StringUtil.toLikeStr(su.getRealName()));
//		}
//		if(StringUtil.isNotEmpty(su.getPhone())){
//			sql.append(" AND phone like ?");
//			params.add(StringUtil.toLikeStr(su.getPhone()));
//		}
//
//		if(StringUtil.isNotEmpty(su.getEmail())){
//			sql.append(" AND email like ?");
//			params.add(StringUtil.toLikeStr(su.getEmail()));
//		}
//		if(su.getStatus()>0){
//			sql.append(" AND t1.status = ?");
//			params.add(su.getStatus());
//		}
//		sql.append(") a");
//		page.setTotalSize(daoSupportOfRead.queryForInt(sql.toString(), params.toArray()));
//		if(page.getTotalSize()<=0){
//			return 0;
//		}
//		return  daoSupportOfRead.queryForInt(sql.toString(), params.toArray());
//	}
//	/**
//	 * 功能描述: 修改用户详细信息
//	 * @auther: huangsenming
//	 * @date: 2018/7/18 10:20
//	 */
//	@Override
//	public boolean changeInfo(UserInfoVO userInfoVO) {
//		StringBuilder sql = new StringBuilder("UPDATE sys_user SET realName=? ");
//		List<Object> params = new ArrayList<>();
//		params.add(userInfoVO.getRealName());
//		if(StringUtil.isNotEmpty(userInfoVO.getEmail())){
//			sql.append(",email=? ");
//			params.add(userInfoVO.getEmail());
//		}
//		if(StringUtil.isNotEmpty(userInfoVO.getPhone())){
//			sql.append(",phone=? ");
//			params.add(userInfoVO.getPhone());
//		}
//		sql.append("where suId=?");
//		params.add(userInfoVO.getSuId());
//		return daoSupportOfWrite.update(sql.toString(), params.toArray())>=0;
//	}
//	/**
//	 * 功能描述: 根据用户名获取用户总数
//	 * @auther: huangsenming
//	 * @date: 2018/7/25 13:32
//	 */
//	@Override
//	public int getUserCount(String realName,int roleId) {
//		StringBuilder sql = new StringBuilder("select count(1) from sys_user a ");
//		sql.append("left join sys_user_role b on a.suId = b.suId ")
//				.append("left join sys_role c on b.roleId = c.roleId ")
//				.append("left join sys_group d on c.groupId = d.groupId ")
//				.append("where a.status <=2  and a.roleType !=2 ");
//		List<Object>  params = new ArrayList<>();
//		if(StringUtil.isNotEmpty(realName)){
//			sql.append(" and realName like ?");
//			params.add(StringUtil.toLikeStr(realName));
//		}
//		if(roleId != 0){
//			sql.append(" and b.roleId =? ");
//			params.add(roleId);
//		}
//		return daoSupportOfRead.queryForInt(sql.toString(),params.toArray());
//	}
//	/**
//	 * 功能描述: 根据用户名获取用户列表
//	 * @auther: huangsenming
//	 * @date: 2018/7/25 13:46
//	 */
//	@Override
//	public List<SysUser> getUserList(Page page, String realName,int roleId) {
//		StringBuilder sql = new StringBuilder("select a.*,c.roleId,c.roleName,d.groupId,d.groupName from sys_user a ");
//		sql.append("left join sys_user_role b on a.suId = b.suId ")
//				.append("left join sys_role c on b.roleId = c.roleId ")
//				.append("left join sys_group d on c.groupId = d.groupId ")
//				.append("where a.status <=2  and a.roleType !=2 ");
//		List<Object>  params = new ArrayList<>();
//		if(StringUtil.isNotEmpty(realName)){
//			sql.append(" and realName like ?");
//			params.add(realName);
//		}
//		if(roleId != 0){
//			sql.append(" and b.roleId =? ");
//			params.add(roleId);
//		}
//		sql.append( "order by ctime desc limit ?,?;");
//		params.add((page.getPage() - 1) * page.getPerSize());
//		params.add(page.getPerSize());
//		return daoSupportOfRead.query(sql.toString(),params.toArray(),mapperBO);
//	}
//	/**
//	 * 功能描述: 是否存在其他的用户名
//	 * @auther: huangsenming
//	 * @date: 2018/7/25 14:14
//	 */
//	@Override
//	public boolean existOtherUser(int suId, String suName) {
//		String sql = "select * from sys_user where suId !=? and suName=? and status<=2";
//		return daoSupportOfRead.queryForInt(sql,new Object[]{suId,suName}) > 0;
//	}
//

    @Override
    public boolean checkUser(String suName) {
        StringBuilder sql = new StringBuilder("select count(1) from sys_user a ");
        sql.append("LEFT JOIN sys_user_role b on b.suId=a.suId ")
                .append("left join sys_role c on c.roleId=b.roleId ")
                .append("LEFT JOIN sys_group d on d.groupId=c.groupId ")
                .append("where a.status=1 and c.status=1 and d.groupStatus=1 and a.suName=?");
        return daoSupportOfRead.queryForInt(sql.toString(), new Object[]{suName}) > 0;
    }
}
