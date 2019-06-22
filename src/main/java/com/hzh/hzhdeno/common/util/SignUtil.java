package com.hzh.hzhdeno.common.util;

import com.hzh.hzhdeno.weixin.WeiXinSign;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

/**
 * @author Administrator
 *
 */
@Slf4j
public class SignUtil {
	
	/**
	 * 
	 * @Title: getParamsFromJson
	 * @Description: TODO从json数据中获取参数，复杂对象先对内层签名
	 * @param json
	 * @param secret
	 * @return Map<String,String>
	 * @author 创建人：王伟
	 * @date 创建时间：2016-10-12 上午10:39:35
	 * @author 修改人：王伟
	 * @throws JSONException
	 * @date 修改时间：2016-10-12 上午10:39:35
	 * @remark 修改备注：
	 */
	public static Map<String, Object> getParamsFromJson(JSONObject json, String secret) throws JSONException {
		
		
		
		if(json == null) return null;
		//获取用户传过来的参数键值对
		Map<String, Object> params = new HashMap<String, Object>();
		Iterator it = json.keys();
		if(it == null) return null;
		while(it.hasNext()){  
			String key = it.next().toString();
			Object param = json.get(key);
        	if(param == null) continue;
        	if(param instanceof JSONObject){
        		if(StringUtil.isEmpty(secret)) continue; 
				params.put(key, WeiXinSign.sign(getParamsFromJson((JSONObject)param, secret), secret));
        	}else if(param instanceof JSONArray){
        		if(StringUtil.isEmpty(secret)) continue; 
        		List<String> list = new ArrayList<String>();
        		for(int i = 0; i < ((JSONArray)param).length(); i ++){
        			list.add(WeiXinSign.sign(getParamsFromJson(((JSONArray)param).getJSONObject(i), secret), secret));
        		}
        		params.put(key, list.toString());
        	}else{
        		if(StringUtil.isEmpty(param.toString())) continue;
        		params.put(key, param.toString());
        	}
		}
		return params;
	}
	
	/**
	 * 
	 * @Title: Sign
	 * @Description: TODO做参数签名
	 * @param secret api用户secret（双方已知的密钥）
	 * @return String
	 * @author 创建人：王伟
	 * @date 创建时间：2016-9-9 上午9:45:04
	 * @author 修改人：王伟
	 * @date 修改时间：2016-9-9 上午9:45:04
	 * @remark 修改备注：
	 */
	/*
	public static String signByOld(Map<String, String> params, String secret){
		//返回空说明签名失败
		if(params == null || params.size() <= 0 || StringUtil.isEmpty(secret)) return null;
		// 第一步：把参数按Key的字母顺序排序
		Collection<String> keyset= params.keySet();
		//对key值排序过程
		List<String> list = new ArrayList<String>(keyset); 
		Collections.sort(list);
		
		// 第二步：把所有参数名和参数值串在一起
        StringBuilder query = new StringBuilder(secret);
        for(String key : list){
            String value = params.get(key);
            if (StringUtil.isNotEmpty(value)){
                query.append(key).append(value);
            }
        }
		
        // 第三部：使用md5运算
        return DigestUtils.md5Hex(query.toString());
	}
	*/
	
	public static String sign(Map<String, String> params, String secret){
		//返回空说明签名失败
		if(params == null || params.size() <= 0 || StringUtil.isEmpty(secret)) return null;
		// 第一步：把参数按Key的字母顺序排序
		Collection<String> keyset= params.keySet();
		//对key值排序过程
		List<String> list = new ArrayList<String>(keyset); 
		Collections.sort(list);
		
		// 第二步：把所有参数名和参数值串在一起
        StringBuilder query = new StringBuilder();
        for(String key : list){
            String value = params.get(key);
            if (StringUtil.isNotEmpty(value)){
                query.append(key).append("=").append(value).append("&");
            }
        }
        if(query.length()>0){
        	query.append("secret="+secret);
        }
        // 第三部：使用md5运算
        return DigestUtils.md5Hex(query.toString());
	}
	/**
	 * 功能描述: 活动Sn签名
	 * @auther: huangsenming
	 * @date: 2018/10/31 10:25
	 */
	public static String actSnSign(String actSn,String secret){
		Map<String, String> map = new HashMap<>();
		map.put("actSn",actSn);
		String sign = sign(map, secret);
		log.info("活动签名为：{}",sign);
		return sign;
	}

	public static void main(String[] args) { //2c23bdb194bca6ac5d3e7a080b808c1b
		System.out.println(actSnSign("act_kpeooi3h7PY","asdfasdf"));
	}
}
