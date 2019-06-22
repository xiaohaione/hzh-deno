package com.hzh.hzhdeno.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.lang.invoke.MethodHandles;

@Repository("daoSupportOfWrite")
public class DaoSupportOfWrite extends DaoSupport {

	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplateWrite;

	public NamedParameterJdbcTemplate getJdbc(){ //返回默认的jdbcTemplate
		return namedJdbcTemplateWrite;
	}







	
}
