package com.cong.nanobatis.test;

import com.cong.nanobatis.io.Resources;
import com.cong.nanobatis.session.SqlSession;
import com.cong.nanobatis.session.SqlSessionFactory;
import com.cong.nanobatis.session.SqlSessionFactoryBuilder;
import com.cong.nanobatis.test.dao.UserDao;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
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
    public void test_MapperProxyFactory() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        // 3. 测试验证
        String res = userDao.queryUserName("10001");
        Assert.assertNotNull(res);
        logger.info("测试结果：{}", res);
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