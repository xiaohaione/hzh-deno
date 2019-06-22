package com.hzh.hzhdeno.common.redis.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 创建人 ylb
 * 创建时间 2018/5/2 16:35
 */
@Setter
@Getter
@ApiModel(value="SuretyOperateInfo", description = "安全调用记录信息")
public class SuretyOperateInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String unionId; // 扫描者unionId
    private int state; // 1、未扫描   2、已扫描  3、确定  4、取消
    private String suretyTag;//确认扫描的tag
    private int suretyId; // 扫描的确认者Id
    private String nodeKey; // 权限节点
    private String message; // 页面提示消息
    private String params; // 接口调用参数

}
