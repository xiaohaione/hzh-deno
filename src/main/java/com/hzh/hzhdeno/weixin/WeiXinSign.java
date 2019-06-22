package com.hzh.hzhdeno.weixin;

import com.hzh.hzhdeno.common.util.StringUtil;

import java.util.*;


/**
 * 微信签名和打包成xml格式数据
 * 
 * @author wjs
 *
 */
public class WeiXinSign {
	public  static String  sign(Map<String, Object> params,String secret){
		StringBuilder sb= new StringBuilder();
		if(params != null && params.size() > 0){
			Collection<String> keyset= params.keySet();
			List<String> list = new ArrayList<String>(keyset);
			//对key键值按字典升序排序
			Collections.sort(list);
			//paySign = "";
			for(String key :list){
				String value = StringUtil.trim(String.valueOf(params.get(key)));
				if(StringUtil.isNotEmpty(value)){
					sb.append(key +"="+value+"&");
				}
			}
		}
		sb.append("secret="+secret);
		return EncryptUtil.md5Hex(sb.toString()).toUpperCase();
	}
}
