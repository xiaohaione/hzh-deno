package com.hzh.hzhdeno.dao;



import com.hzh.hzhdeno.entity.SysUser;


public interface ISysUserDao {

	/**
	 * 
	 * @Title: getUserBySuName
	 * @Description: 根据用户名称查询用户信息包括部门名称
	 * @param  suName 用户名称
	 * @return SysUser  返回获得的用户信息{@link SysUser}
	 */
	public SysUser getUserBySuName(String suName) throws Exception;
//	/**
//	 *
//	 * @Title: updatePassword
//	 * @Description: 根据用户名称和ID 更新密码
//	 * @param  suId 需要更新的用户ID
//	 * @param  password 需要更新的密码
//	 * @return boolean    true-更新成功，false-更新失败
//	 */
//	public boolean updatePassword(int suId, String password) throws Exception;
//	/**
//	 *
//	 * @Title: updateRealName
//	 * @Description: 更新用户信息
//	 * @param  su 需要更新的用户{@link SysUser}信息
//	 * @return boolean    true-更新成功，false-更新失败
//	 */
//	public boolean updateRealName(SysUser su) throws Exception;
//	/**
//	 * 分页查询用户信息，机构管理只能查看本部门以及子部门用户信息，系统管理可以查看全部
//	 * @param page 分页对象信息{@link Page}
//	 * @param su  需要查询的用户条件信息{@link SysUser}
//	 * @param roleId 角色Id
//	 * @return 返回根据条件查询获得的用户信息{@link SysUserExpand}
//	 */
//	public List<SysUser> getUserList(Page page, SysUser su, int groupId, int roleId, String realName) throws Exception;

	/**
	 * @param suName 需要查询用户{@link SysUser}的用户名
	 * @return int    返回根据用户{@link SysUser}}名称查询得到的用户ID
	 * @Title: getSuIdBySuName
	 * @Description: 根据用户名{@link SysUser}}查询用户的ID
	 */
	public int getSuIdBySuName(String suName) throws Exception;
	/**
	 *
	 * @Title: createUser
	 * @Description: 添加管理员
	 * @param  su 需要添加的管理员信息
	 * @return boolean    返回新增数据的id
	 */
	public int createUser(SysUser su) throws Exception;
//	/**
//	 *
//	 * @Title: getUser
//	 * @Description: 根据用户ID获取用户信息
//	 * @param  suId 用户ID
//	 * @return SysUser    返回获得的用户信息{@link SysUser}
//	 */
//	public SysUser getUser(int suId);
//	/**
//	 *
//	 * @Title: updateUser
//	 * @Description: 更新用户信息
//	 * @param  su 需要添加的管理员信息
//	 * @return boolean   true-更新成功，false-更新失败
//	 */
//	public boolean updateUser(SysUser su) throws Exception;
//	/**
//	 *
//	 * @Title: updateStatus
//	 * @Description: 根据用户ID和名称更新状态
//	 * @param  suId 需要更新的用户ID
//	 * @param  state 需要更新的状态
//	 * @return boolean    true-更新成功，false-更新失败
//	 */
//	public boolean updateStatus(int suId, int state) throws Exception;
//	/**
//	 *
//	 * @Title: deleteUser
//	 * @Description: 根据用户ID和名称删除用户
//	 * @param  suId 用户ID
//	 * @param  suName 用户名称
//	 * @return boolean    true-删除成功，false-删除失败
//	 */
//	public boolean deleteUser(int suId) throws Exception;
//	/**
//	 * 获得机构下所有用户
//	 *
//	 * @param page 页码信息
//	 * @param su 用户搜索条件
//	 * @param groupIdList 当前用户有权限的机构Id
//	 * @param roleId 角色Id 查询条件
//	 * @return List<SysUser>
//	 * @author 创建人：ylb
//	 * @date 创建时间：2017-6-30 下午7:31:15
//	 */
//	public List<SysUser> getSysUserList(Page page, SysUser su, List<Integer> groupIdList, int roleId) throws Exception;
//	/**
//	 * 根据机构Id获得用户列表
//	 *
//	 * @param groupId 机构Id
//	 * @return List<Map<String,Object>>
//	 * @author 创建人：ylb
//	 * @date 创建时间：2017-7-14 上午11:29:41
//	 */
//	public List<Map<String, Object>> getSysUserListByGroupId(int groupId) throws Exception;
//	/**
//	 * 根据机构Id获得机构下所有用户
//	 *
//	 * @param groupId 机构Id
//	 * @return List<Map<String,Object>>
//	 * @author 创建人：ylb
//	 * @date 创建时间：2017-9-7 下午2:08:03
//	 */
//	public List<Map<String, Object>> getAllSysUserByGroupId(int groupId) throws Exception;
//	/**
//	 * 获得用户的信息
//	 *
//	 * @param suId
//	 * @return Map<String,Object>
//	 * @author 创建人：ylb
//	 * @date 创建时间：2017-8-17 下午3:25:38
//	 */
//	public Map<String, Object> getSysUserType(int suId) throws Exception;
//
//	SysUser getUserByOpenId(String openId);
//
//	int getUserListTotal(Page page, SysUser su, int groupId, int roleId, String realName);
//
//	int getUserListTotal2(Page page, SysUser su, List<Integer> groupIdList, int roleId);
//	/**
//	 * 功能描述: 修改用户详细信息
//	 * @auther: huangsenming
//	 * @date: 2018/7/18 10:20
//	 */
//	boolean changeInfo(UserInfoVO userInfoVO);
//	/**
//	 * 功能描述: 根据用户名获取用户总数
//	 * @auther: huangsenming
//	 * @date: 2018/7/25 13:32
//	 */
//	int getUserCount(String realName, int roleId);
//	/**
//	 * 功能描述: 根据用户名获取用户列表
//	 * @auther: huangsenming
//	 * @date: 2018/7/25 13:45
//	 */
//	List<SysUser> getUserList(Page page, String realName, int roleId);
//	/**
//	 * 功能描述: 是否存在其他的用户名
//	 * @auther: huangsenming
//	 * @date: 2018/7/25 14:13
//	 */
//	boolean existOtherUser(int suId, String suName);
//	/**
//	 * 功能描述: 检查用户角色,部门状态是否征程
//	 * @auther: huangsenming
//	 * @date: 2018/8/1 14:05
//	 */
	boolean checkUser(String suName);
}
