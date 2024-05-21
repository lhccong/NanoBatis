package com.cong.nanobatis.session.defaults;

import com.cong.nanobatis.mapping.MappedStatement;
import com.cong.nanobatis.session.Configuration;
import com.cong.nanobatis.session.SqlSession;

/**
 * 默认 SqlSession 实现类
 *
 * @author cong
 * @date 2024/05/21
 */
public class DefaultSqlSession implements SqlSession {

    /**
     * 映射器注册机
     */
    private final Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理了！" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        MappedStatement mappedStatement = configuration.getMappedStatement(statement);
        return (T) ("你被代理了！" + "\n方法：" + statement + "\n入参：" + parameter + "\n待执行SQL：" + mappedStatement.getSql());
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }

}