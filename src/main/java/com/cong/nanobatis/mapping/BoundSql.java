package com.cong.nanobatis.mapping;

import java.util.Map;

/**
 * 绑定的SQL,是从 SqlSource 而来，将动态内容都处理完成得到的SQL语句字符串，其中包括?,还有绑定的参数
 *
 * @author cong
 * @date 2024/05/24
 */
public class BoundSql {

    private final String sql;
    private final Map<Integer, String> parameterMappings;
    private final String parameterType;
    private final String resultType;

    public BoundSql(String sql, Map<Integer, String> parameterMappings, String parameterType, String resultType) {
        this.sql = sql;
        this.parameterMappings = parameterMappings;
        this.parameterType = parameterType;
        this.resultType = resultType;
    }

    public String getSql() {
        return sql;
    }

    public Map<Integer, String> getParameterMappings() {
        return parameterMappings;
    }

    public String getParameterType() {
        return parameterType;
    }

    public String getResultType() {
        return resultType;
    }
}
