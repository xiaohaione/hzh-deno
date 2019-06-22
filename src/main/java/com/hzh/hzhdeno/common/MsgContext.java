package com.hzh.hzhdeno.common;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hzh.hzhdeno.common.util.StringUtil;
import com.hzh.hzhdeno.constans.ResultState;
import org.json.JSONObject;


import java.io.Serializable;

// 序列化忽略空值属性
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class MsgContext implements Serializable {
	private static final long serialVersionUID = 2710104430574685991L;

	private int state;//返回状态 1表示正确  等于0错误
	private int code;//状态码
	private String message;//消息
	private String desc;
	private int id;
	private Object info;
	private String name;
	public MsgContext(){

	}
	public MsgContext(int state){
		ResultState resultState = state==1 ? ResultState.SUCCESS : ResultState.FAILURE;
		this.state = resultState.isState();
		this.code = resultState.getCode();
		this.message = resultState.getMessage();
	}
	
	public MsgContext(ResultState resultState){
		this.state = resultState.isState();
		this.code = resultState.getCode();
		this.message = resultState.getMessage();
	}
	
	public MsgContext setResultState(ResultState resultState){
		this.state = resultState.isState();
		this.code = resultState.getCode();
		this.message = resultState.getMessage();
		return this;
	}
	
	public Object getInfo() {
		return info;
	}
	
	public MsgContext setInfo(Object info) {
		this.info = info;
		return this;
	}
	
	public int isState() {
		return state;
	}
	
	public int getCode() {
		return code;
	}
	public int getState(){
		return state;
	}
	public String getMessage() {
		return message;
	}

	public MsgContext setMessage(String message) {
		this.message = message;
		return this;
	}
	public String getDesc() {
		return desc;
	}

	public MsgContext setDesc(String desc){
		if(StringUtil.isEmpty(this.message)){
			this.message = desc;
		}else{
			this.message = this.message + "," + desc;
		}
		this.desc = desc;
		return this;
	}
	
	public int getId() {
		return id;
	}
	
	public MsgContext setId(int id) {
		this.id = id;
		return this;
	}
	public MsgContext setState(int state) {
		this.state = state;
		return this;
	}
	
	public String getName() {
		return name;
	}

	public MsgContext setName(String name) {
		this.name = name;
		return this;
	}

	public String toString(){
		String info = this.info==null?null:this.info.toString();
		StringBuffer json = new StringBuffer();
		json.append("{\"state\":").append(state).append(",");
		json.append("\"code\":\"").append(code).append("\",");
		json.append("\"message\":\"").append(message).append("\",");
		if(StringUtil.isNotEmpty(name)){
			json.append("\"name\":\"").append(name).append("\",");
		}
		if(info!=null && ((info.startsWith("{") && info.endsWith("}")) 
				||( info.startsWith("[") && info.endsWith("]"))) ){
			json.append("\"info\":").append(info);
		}else{
			if(info!=null){
					info = info.replace("\"", "\\\"");
					json.append("\"info\":\"").append(info).append("\"");
			}else{
				json.append("\"info\":null");
			}
		}
		json.append("}");
		return json.toString();
	}
	
	public JSONObject toJson(){
		try{
	        JSONObject json = new JSONObject();
			json.put("state", state);
			json.put("code", code);
			json.put("message", message);
			if(StringUtil.isNotEmpty(name)){
				json.put("name", name);
			}
        	ObjectMapper objectMapper = new ObjectMapper();
	        //业务数据
	        if(this.info != null){
	        	JSONObject infoJson = new JSONObject(objectMapper.writeValueAsString(this.info));
	        	json.put("info", infoJson);
	        }
	        return json;
	    }catch (Exception e){
	        e.printStackTrace();
	        return new JSONObject();
	    }
	}
}
