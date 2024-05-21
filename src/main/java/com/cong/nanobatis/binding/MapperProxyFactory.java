package com.cong.nanobatis.binding;

import com.cong.nanobatis.session.SqlSession;

import java.lang.reflect.Proxy;

/**
 * Mapper 代理工厂
 *
 * @author cong
 * @date 2024/05/21
 */
public class MapperProxyFactory<T> {

    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public T newInstance(SqlSession sqlSession) {
        final MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, mapperInterface);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    }

}
