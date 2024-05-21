package com.cong.nanobatis.session.defaults;

import com.cong.nanobatis.session.Configuration;
import com.cong.nanobatis.session.SqlSession;
import com.cong.nanobatis.session.SqlSessionFactory;

/**
 * 默认的 DefaultSqlSessionFactory
 *
 * @author cong
 * @date 2024/05/21
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }

}