package com.hzh.hzhdeno.annotion;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 拦截白名单
 * @author wjs
 * @date 2017-5-11 
 *
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface ExcludeMapping {

	public boolean  value() default true;
}
