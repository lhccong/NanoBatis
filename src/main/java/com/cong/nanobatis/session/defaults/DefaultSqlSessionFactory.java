package com.cong.nanobatis.session.defaults;

import com.cong.nanobatis.binding.MapperRegistry;
import com.cong.nanobatis.session.SqlSession;
import com.cong.nanobatis.session.SqlSessionFactory;

/**
 * 默认的 DefaultSqlSessionFactory
 *
 * @author cong
 * @date 2024/05/21
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }

}