package com.hzh.hzhdeno.service.impl;

import com.hzh.hzhdeno.common.MsgContext;
import com.hzh.hzhdeno.common.MyTransSupport;
import com.hzh.hzhdeno.constans.ResultState;
import com.hzh.hzhdeno.dao.ISysUserDao;
import com.hzh.hzhdeno.entity.SysUser;
import com.hzh.hzhdeno.service.ISysUserRoleDao;
import com.hzh.hzhdeno.service.ISysUserService;
import com.hzh.hzhdeno.weixin.util.Tools;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;

import java.util.List;

/**
 * create by: hezhihai
 * description: TODO
 * create time: 2019/4/26 11:32
 */
@Service
public class SysUserService extends MyTransSupport implements ISysUserService {
    @Autowired
    private ISysUserDao sysUserDao;

    @Autowired
    private ISysUserRoleDao sysUserRoleDao;
    @Value("${wx.appid}")
    private String head ;
//	@Autowired
//	private ISysUserRoleDao sysUserRoleDao;
//	@Autowired
//	private ISysGroupDao sysGroupDao;
//	@Autowired
//	private ISysRoleDao sysRoleDao;

    @Override
    public SysUser getSysUser(String suName) throws Exception {
        return sysUserDao.getUserBySuName(suName);
    }

    /**
     * @param su 需要添加的管理员信息
     * @param
     * @return
     * @throws Exception
     */
    @Override
    public MsgContext createSysUser(SysUser su) throws Exception {
        int suId = sysUserDao.getSuIdBySuName(su.getSuName());
        if (suId > 0) {
            return new MsgContext(ResultState.EXIST_SYS_USER).setName("suName");
        }
        su.setPassword(DigestUtils.md5Hex(su.getPassword()));
//        if (roleIds == null || roleIds.length <= 0) {
//            return new MsgContext(ResultState.PARAM_ERROR).setDesc("请选择管理员角色");
//        }
//        if (roleIds.length != 1) {
//            return new MsgContext(ResultState.ADMINISTRATOR_ONLY_ONE);
//        }
//        List<Integer> list = Tools.strsToList(roleIds);
//        TransactionStatus status = getTxStatus();
        boolean r = true;
        try {
            r = r && (sysUserDao.createUser(su) > 0);
//            if (r && list != null && list.size() > 0) {
//                r = r && sysUserRoleDao.addSysUserRole(list, su.getSuId());
//            }
        } catch (Exception e) {
            r = false;
        } finally {
//            commit(status, r);
        }
        return new MsgContext(r ? 1 : 0);
    }

    //@Override
    //public MsgContext updatePassword(SysUser su, int suId, String suName, String password) throws Exception {
//		if(su.getRoleType() != 2 && su.getSuId() != suId){
//			//获得用户的所有角色Id
//			List<Integer> roleIdList = sysUserRoleDao.getSysUserRole(suId);
//			//用户如果存在机构管理员的角色
//			boolean existManager = sysRoleDao.existManager(roleIdList);
//			if(existManager){
//				return new MsgContext(ResultState.ROLES_CONTAIN_ADMINISTRATOR);
//			}
//		}
    //	boolean r = sysUserDao.updatePassword(suId, suName, password);
    //	return new MsgContext(r?1:0);
    //}
//	@Override
//	public MsgContext updatePassword(int suId, String password) throws Exception {
//		boolean r = sysUserDao.updatePassword(suId, password);
//		return new MsgContext(r?1:0);
//	}
//
//
//	@Override
//	public MsgContext createSysUser(SysUser su,String[] roleIds) throws Exception {
//		int suId = sysUserDao.getSuIdBySuName(su.getSuName());
//		if(suId>0){
//			return new MsgContext(ResultState.EXIST_SYS_USER).setName("suName");
//		}
//		su.setPassword(DigestUtils.md5Hex(su.getPassword()));
//		if(roleIds == null || roleIds.length <= 0){
//			return new MsgContext(ResultState.PARAM_ERROR).setDesc("请选择管理员角色");
//		}
//		if(roleIds.length != 1){
//			return new MsgContext(ResultState.ADMINISTRATOR_ONLY_ONE);
//		}
//		List<Integer> list = Tools.strsToList(roleIds);
//		TransactionStatus status = getTxStatus();
//		boolean r = true;
//		try{
//			r = r && (sysUserDao.createUser(su) >0 );
//			if(r && list != null && list.size() > 0){
//				r = r && sysUserRoleDao.addSysUserRole(list, su.getSuId());
//			}
//		}catch (Exception e) {
//			r = false;
//		}finally{
//			commit(status, r);
//		}
//		return new MsgContext(r?1:0);
//	}
//
//	@Override
//	public SysUser getSysUser(int suId) throws Exception {
//		return sysUserDao.getUser(suId);
//	}
//
//	@Override
//	public MsgContext updateStatus(int suId, int state) throws Exception {
//		TransactionStatus status = getTxStatus();
//		boolean r = false;
//		try {
//			r = sysUserDao.updateStatus(suId, state);
//		} catch (Exception e) {
//			r = false;
//		}finally{
//			commit(status, r);
//		}
//		return new MsgContext(r?1:0);
//	}
//
//	@Override
//	public MsgContext deleteSysUser(int suId) throws Exception {
//		SysUser oldUser = sysUserDao.getUser(suId);
//		if(oldUser != null){
//			new MsgContext(ResultState.NO_RESULT).setDesc("没有对应的用户");
//		}
//		TransactionStatus status = getTxStatus();
//		boolean r = true;
//		try {
//			//删除用户信息
//			r = r && sysUserDao.deleteUser(suId);
//			//删除用户角色信息表
//			r = r && sysUserRoleDao.deleteUserRoleBySuId(suId);
//		} catch (Exception e) {
//			r = false;
//		}finally{
//			commit(status, r);
//		}
//		return new MsgContext(r?1:0);
//	}
//
//	/**
//	 * 功能描述: 根据用户名模糊查询用户列表
//	 * @auther: huangsenming
//	 * @date: 2018/7/25 13:26
//	 */
//	@Override
//	public Map<String, Object> getUserList(Page page,String realName,int roleId) {
//		Map<String, Object> map = new HashMap<>();
//		int total = sysUserDao.getUserCount(realName,roleId);
//		List<SysUser> list = sysUserDao.getUserList(page,realName,roleId);
//		int totalPage = total % (page.getPerSize()) > 0 ? (total / (page.getPerSize()) + 1) : (total / (page.getPerSize()));
//		page.setTotalSize(total);
//		page.setTotalPage(totalPage);
//		map.put("suList", list);
//		map.put("page",page);
//		return map;
//	}
//	/**
//	 * 功能描述: 更新用户信息
//	 * @auther: huangsenming
//	 * @date: 2018/7/25 14:08
//	 */
//	@Override
//	public MsgContext updateSysUser(SysUser user, String[] roleIds) {
//		if(sysUserDao.existOtherUser(user.getSuId(),user.getSuName())){
//			return new MsgContext(ResultState.RECORD_EXISTS).setDesc("已存在登录用户");
//		}
//		if(roleIds == null || roleIds.length <= 0){
//			return new MsgContext(ResultState.PARAM_ERROR).setDesc("请选择管理员角色");
//		}
//		if(roleIds.length != 1){
//			return new MsgContext(ResultState.ADMINISTRATOR_ONLY_ONE);
//		}
//		List<Integer> list = Tools.strsToList(roleIds);
//		TransactionStatus status = getTxStatus();
//		boolean r = true;
//		try{
//			//更新用户信息
//			r = r && sysUserDao.updateUser(user);
//			//删除原来的用户角色表
//			r = r && sysUserRoleDao.deleteUserRoleBySuId(user.getSuId());
//			//新增用户角色表
//			if(r && list != null && list.size() > 0){
//				r = r && sysUserRoleDao.addSysUserRole(list, user.getSuId());
//			}
//		}catch (Exception e) {
//			r = false;
//		}finally{
//			commit(status, r);
//		}
//		return new MsgContext(r?1:0);
//	}

    /**
     * create by: hezhihai
     * description: TODO
     * create time: 2019/4/26 11:49
     */
    @Override
    public boolean checkUser(String suName) {
        return sysUserDao.checkUser(suName);
    }
}
