package com.hzh.hzhdeno.exception;

import org.springframework.dao.DataAccessException;

/**
 * DaoSupport自定义异常
 */
public class DaoAccessException extends DataAccessException {
    public DaoAccessException(String msg) {
        super(msg);
    }

    public DaoAccessException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
