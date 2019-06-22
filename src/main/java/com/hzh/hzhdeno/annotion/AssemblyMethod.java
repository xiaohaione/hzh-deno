package com.hzh.hzhdeno.annotion;

import com.hzh.hzhdeno.constans.OperateEnums;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 自定义权限注解
 * 
 * @author wjs
 * @date 2017-6-20 
 *
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface AssemblyMethod {

	
	/**
	 * 操作权限
	 * @author wjs
	 * @date 2017-7-1 
	 * @return
	 */
	OperateEnums[] operateEnums();
	
	
	/**
	 * 是否为主入口:
	 */
	boolean entrance() default false;

	/**
	 * 节点类型:,1.默认需要配置权限，
	 * 2：不需要配置权限都可以访问，3：不能授权限，只能系统管理员可以访问
	 * @author wjs
	 * @date 2017-7-4 
	 * @return
	 */
	int nodeType() default 1;

	/**
	 * 该操作名字
	 * @author wjs
	 * @date 2017-7-1 
	 * @return
	 */
	String name() ;
}
