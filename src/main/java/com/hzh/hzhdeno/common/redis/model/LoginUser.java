package com.hzh.hzhdeno.common.redis.model;


import com.hzh.hzhdeno.entity.SysUser;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class LoginUser implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 4821499761327903442L;
    private String token;
    private SysUser sysUser;
    private Map<String, SuretyOperateInfo> suretyOperateInfoMap = new HashMap<String, SuretyOperateInfo>();

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public SuretyOperateInfo getSuretyOperateInfo(String code) {
        return suretyOperateInfoMap.get(code);
    }

    public void setSuretyOperateInfo(String code, SuretyOperateInfo suretyOperateInfo) {
        this.suretyOperateInfoMap.put(code, suretyOperateInfo);
    }

    public void removeSuretyOperateInfo(String code) {
        this.suretyOperateInfoMap.remove(code);
    }
}
