package com.hzh.hzhdeno.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class SqlUtil {

    private static Logger logger= LoggerFactory.getLogger(SqlUtil.class);

    public static String addEqualStringParam(String dbName,String dtoValue){
        return " and "+dbName+"='"+dtoValue+"'";
    }

    public static String addLikeStringParam(String dbName,String dtoValue){
        return " and "+dbName+"like %'"+dtoValue+"'%";
    }

    /**
     * @param e
     * @param sql
     * @param params
     */
    public static void printSql( Exception e, String sql, Object... params){
        logger.error("error-sql:" + sql + "\r\n,sql-param" + Arrays.toString(params)+"\r\n"+e);

    }
}
