package com.hzh.hzhdeno.dao.rowmapper;


import com.hzh.hzhdeno.entity.SysUser;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class SysUserRowmapper implements RowMapper<SysUser> {

	public SysUser mapRow(ResultSet rs, int rowNum) throws SQLException {
		SysUser model = new SysUser();
		model.setSuId(rs.getInt("suId"));
		model.setSuName(rs.getString("suName"));
		model.setPassword(rs.getString("password"));
		model.setRoleType(rs.getInt("roleType"));
		model.setRealName(rs.getString("realName"));
		model.setPhoto(rs.getString("photo"));
		model.setPhone(rs.getString("phone"));
		model.setEmail(rs.getString("email"));
//		model.setWxNo(rs.getString("wxNo"));
//		model.setOauthId(rs.getString("oauthId"));
		model.setState(rs.getInt("state"));
		model.setCtrime(rs.getString("ctrime"));
		return model;
	}
}
