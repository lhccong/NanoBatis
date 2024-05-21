package com.cong.nanobatis.test;

import com.cong.nanobatis.MapperProxyFactory;
import com.cong.nanobatis.test.dao.UserDao;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;



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
        MapperProxyFactory<UserDao> factory = new MapperProxyFactory<>(UserDao.class);
        //在单测中创建 MapperProxyFactory 工厂，并手动给 sqlSession Map 赋值，这里的赋值相当于模拟数据库中的操作
        Map<String, String> sqlSession = new HashMap<>();
        sqlSession.put("com.cong.nanobatis.test.dao.UserDao.queryUserName", "模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户姓名");
        sqlSession.put("com.cong.nanobatis.test.dao.UserDao.queryUserAge", "模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户年龄");
        //接下来再把赋值信息传递给代理对象实例化操作，这样就可以在我们调用具体的 DAO 方法时从 sqlSession 中取值了
        UserDao userDao = factory.newInstance(sqlSession);

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