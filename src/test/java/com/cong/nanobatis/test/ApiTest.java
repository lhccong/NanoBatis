package com.cong.nanobatis.test;

import com.cong.nanobatis.binding.MapperRegistry;
import com.cong.nanobatis.session.SqlSession;
import com.cong.nanobatis.session.SqlSessionFactory;
import com.cong.nanobatis.session.defaults.DefaultSqlSessionFactory;
import com.cong.nanobatis.test.dao.UserDao;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;



/**
 * API 测试
 *
 * @author cong
 * @date 2024/05/21
 */
public class ApiTest {

    private final Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_MapperProxyFactory() {
        // 1. 注册 Mapper
        MapperRegistry registry = new MapperRegistry();
        registry.addMappers("com.cong.nanobatis.test.dao");

        // 2. 从 SqlSession 工厂获取 Session
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(registry);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取映射器对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        // 4. 测试验证
        String res = userDao.queryUserName("10001");
        logger.info("测试结果：{}", res);
        Assert.assertNotNull(res);
    }

    @Test
    public void test_proxy_class() {
        UserDao userDao = (UserDao) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class[]{UserDao.class}, (proxy, method, args) -> "你被代理了！");
        String result = userDao.queryUserName("10001");
        Assert.assertNotNull(result);
        System.out.println("测试结果：" + result);
    }

}