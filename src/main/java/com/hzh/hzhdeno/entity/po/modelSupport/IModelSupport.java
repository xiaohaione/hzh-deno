package com.hzh.hzhdeno.entity.po.modelSupport;


import com.hzh.hzhdeno.common.MsgContext;

import javax.servlet.http.HttpServletRequest;

public interface IModelSupport <T> {
	/**
	 * 从request中读取实体类信息
	 * @param request
	 * @return
	 */
	public T get(HttpServletRequest request);
	
	/**
	 * 验证数据合法性
	 * @param model 要检查的数据
	 * @param desc 说明
	 * @param type 类型，1：增加，2：修改
	 * @return
	 */
	public MsgContext check(T model, final String desc, int type);
}
