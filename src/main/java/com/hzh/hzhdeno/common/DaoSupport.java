package com.hzh.hzhdeno.common;



import com.hzh.hzhdeno.common.util.SqlUtil;
import com.hzh.hzhdeno.exception.DaoAccessException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public abstract class DaoSupport {

    public abstract NamedParameterJdbcTemplate getJdbc();

    public <T> T queryForObject(String sql, Object[] params, RowMapper<T> rowMapper) {
        try {
            List<T> list = getJdbc().getJdbcOperations().query(sql, params, rowMapper);
            if (list == null || list.size() < 1) {
                return null;
            } else {
                return list.get(0);
            }
        } catch (Exception e) {
            SqlUtil.printSql(e, sql, params);
            e.printStackTrace();
            throw new DaoAccessException("queryForObject 异常！SQL:" + sql, e);
        }
    }

    public int update(final String sql, final Object... params) {
        try {
            return getJdbc().getJdbcOperations().update(sql, params);
        } catch (Exception e) {
            SqlUtil.printSql(e, sql, params);
            e.printStackTrace();
            throw new DaoAccessException("update 异常！SQL:" + sql, e);
        }
    }

    public int[] batchUpdate(String... sqls) {
        try {

            return getJdbc().getJdbcOperations().batchUpdate(sqls);
        } catch (Exception e) {

            String sql_info = Arrays.stream(sqls).collect(Collectors.joining(";"));

            SqlUtil.printSql(e, sql_info);
            e.printStackTrace();
            throw new DaoAccessException("batchInsert 异常！SQL:" + sql_info, e);
        }
    }

    /**
     * 批量执行数据库更新（以名称代替占位符（？））
     *
     * @param sql
     * @param params
     * @return int[]
     * @author elis cheng
     * @date 20180704
     */
    public int[] batch(String sql, Object... params) {
        try {
            SqlParameterSource[] args = SqlParameterSourceUtils.createBatch(params);

            int[] results = getJdbc().batchUpdate(sql, args);

            return results;
        } catch (Exception e) {
            SqlUtil.printSql(e, sql, params);
            e.printStackTrace();
            throw new DaoAccessException("batchInsert 异常！SQL:" + sql, e);
        }

    }

    /**
     * @param sql
     * @param params
     * @return
     * @throws Exception
     */
    public int insert(final String sql, final Object... params) {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            getJdbc().getJdbcOperations().update(new PreparedStatementCreator() {
                public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                    PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    if (params != null && params.length > 0) {
                        for (int i = 0; i < params.length; i++) {
                            pstmt.setObject(i + 1, params[i]);
                        }
                    }
                    return pstmt;
                }
            }, keyHolder);
            return keyHolder.getKey().intValue();
        } catch (Exception e) {
            SqlUtil.printSql(e, sql, params);
            e.printStackTrace();
            throw new DaoAccessException("insert 异常！SQL:" + sql, e);
        }
    }

    public Boolean execute(String sql) {
        try {
            getJdbc().getJdbcOperations().execute(sql);
            return true;
        } catch (Exception e) {
            SqlUtil.printSql(e, sql);
            e.printStackTrace();
            throw new DaoAccessException("execute 异常！SQL:" + sql, e);
        }
    }

    public String queryForString(String sql, Object... params) {
        try {
            SqlRowSet rs = getJdbc().getJdbcOperations().queryForRowSet(sql, params);
            if (rs.first()) {
                String str = rs.getString(1);
                return str;
            }
            return null;
        } catch (Exception e) {
            SqlUtil.printSql(e, sql, params);
            e.printStackTrace();
            throw new DaoAccessException("queryForString 异常！SQL:" + sql, e);
        }
    }

    public int queryForInt(String sql, Object... params) {
        try {
            SqlRowSet rs = getJdbc().getJdbcOperations().queryForRowSet(sql, params);
            if (rs.first()) {
                int value = rs.getInt(1);
                return value;
            }
            return 0;
        } catch (Exception e) {
            SqlUtil.printSql(e, sql, params);
            e.printStackTrace();
            throw new DaoAccessException("queryForInt 异常！SQL:" + sql, e);
        }
    }

    public boolean queryForExist(String sql, Object[] params) {
        try {
            SqlRowSet rs = getJdbc().getJdbcOperations().queryForRowSet(sql, params);
            if (rs.first()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            SqlUtil.printSql(e, sql, params);
            e.printStackTrace();
            throw new DaoAccessException("queryForExist 异常！SQL:" + sql, e);
        }
    }

    public <T> List<T> query(String sql, Object[] params, RowMapper<T> rowMapper) {
        try {
            return getJdbc().getJdbcOperations().query(sql, params, rowMapper);
        } catch (Exception e) {
            SqlUtil.printSql(e, sql, params);
            e.printStackTrace();
            throw new DaoAccessException("query 异常！SQL:" + sql, e);
        }
    }

    public List<Map<String, Object>> queryForList(String sql, Object... params) {
        try {
            List<Map<String, Object>> list = getJdbc().getJdbcOperations().queryForList(sql, params);
            return list;
        } catch (Exception e) {
            SqlUtil.printSql(e, sql, params);
            e.printStackTrace();
            throw new DaoAccessException("queryForList 异常！SQL:" + sql, e);
        }
    }

    /*
     * 查询一列String类型的数据，以列表形式返回
     * author ww
     * 2014-10-23
     */
    public List<String> queryForStringList(String sql, Object... params) {
        try {
            SqlRowSet rs = getJdbc().getJdbcOperations().queryForRowSet(sql, params);
            List<String> list = new ArrayList<String>();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            return list;
        } catch (Exception e) {
            SqlUtil.printSql(e, sql, params);
            e.printStackTrace();
            throw new DaoAccessException("queryForList 异常！SQL:" + sql, e);
        }
    }

    /*
     * 查询一列Integer类型的数据，以列表形式返回
     * author ww
     * 2014-10-23
     */
    public List<Integer> queryForIntList(String sql, Object... params) {
        try {
            SqlRowSet rs = getJdbc().getJdbcOperations().queryForRowSet(sql, params);
            List<Integer> list = new ArrayList<Integer>();
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            return list;
        } catch (Exception e) {
            SqlUtil.printSql(e, sql, params);
            e.printStackTrace();
            throw new DaoAccessException("queryForIntList 异常！SQL:" + sql, e);
        }
    }


    public Map<String, Object> queryForMap(String sql, Object... params) {
        try {
            List<Map<String, Object>> list = getJdbc().getJdbcOperations().queryForList(sql, params);
            if (list == null || list.size() <= 0) {
                return null;
            } else {
                return list.get(0);
            }
        } catch (Exception e) {
            SqlUtil.printSql(e, sql, params);
            e.printStackTrace();
            throw new DaoAccessException("queryForMap 异常！SQL:" + sql, e);
        }
    }

    public <T> T call(final String sql, final Object[] params, final RowMapper<T> mapper) throws Exception {
        T t = getJdbc().getJdbcOperations().execute(new CallableStatementCreator() {
            @Override
            public CallableStatement createCallableStatement(Connection conn) throws SQLException {
                CallableStatement stmt = conn.prepareCall(sql);
                if (params != null && params.length > 0) {
                    for (int i = 0; i < params.length; i++) {
                        stmt.setObject(i + 1, params[i]);
                    }
                }
                return stmt;
            }

        }, new CallableStatementCallback<T>() {
            @Override
            public T doInCallableStatement(CallableStatement stmt) throws SQLException, DataAccessException {
                ResultSet rs = stmt.getResultSet();
                int rowNum = 0;
                if (rs.getRow() <= 0) {
                    return null;
                }
                if (rs.next()) {
                    T t = mapper.mapRow(rs, rowNum++);
                    return t;
                }
                return null;
            }
        });
        return t;
    }

    public <T> List<T> callList(final String sql, final Object[] params, final RowMapper<T> mapper) throws Exception {
        List<T> list = getJdbc().getJdbcOperations().execute(new CallableStatementCreator() {
            @Override
            public CallableStatement createCallableStatement(Connection conn) throws SQLException {
                CallableStatement stmt = conn.prepareCall(sql);
                if (params != null && params.length > 0) {
                    for (int i = 0; i < params.length; i++) {
                        stmt.setObject(i + 1, params[i]);
                    }
                }
                return stmt;
            }

        }, new CallableStatementCallback<List<T>>() {
            @Override
            public List<T> doInCallableStatement(CallableStatement stmt) throws SQLException, DataAccessException {
                ResultSet rs = stmt.getResultSet();
                int rowNum = 0;
                if (rs.getRow() <= 0) {
                }
                List<T> list = new ArrayList<T>(rs.getRow());
                while (rs.next()) {
                    T t = mapper.mapRow(rs, rowNum++);
                    list.add(t);
                }
                return list;
            }
        });
        return list;
    }

    /**
     * 批量执行数据库更新（以名称代替占位符（？））
     *
     * @param sql
     * @param params
     * @return int[]
     * @author elis cheng
     * @date 20180704
     */
    public int[] batchInsert(String sql, Object... params) {

        SqlParameterSource[] args = SqlParameterSourceUtils.createBatch(params);

        int[] results = getJdbc().batchUpdate(sql, args);

        return results;

    }
}
