package com.cong.nanobatis.session.defaults;

import com.cong.nanobatis.binding.MapperRegistry;
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
    private final MapperRegistry mapperRegistry;

    public DefaultSqlSession(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理了！" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return (T) ("你被代理了！" + "方法：" + statement + " 入参：" + parameter);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return mapperRegistry.getMapper(type, this);
    }

}