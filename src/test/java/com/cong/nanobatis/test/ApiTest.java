package com.cong.nanobatis.test;

import cn.hutool.json.JSONUtil;
import com.cong.nanobatis.io.Resources;
import com.cong.nanobatis.session.SqlSession;
import com.cong.nanobatis.session.SqlSessionFactory;
import com.cong.nanobatis.session.SqlSessionFactoryBuilder;
import com.cong.nanobatis.test.dao.UserDao;
import com.cong.nanobatis.test.po.User;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Proxy;
import java.sql.Date;


/**
 * API 测试
 *
 * @author cong
 * @date 2024/05/21
 */
public class ApiTest {

    private final Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_SqlSessionFactory() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config-datasource.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        // 3. 测试验证
        User user = userDao.queryUserInfoById(1L);
        Assert.assertNotNull(user);
        logger.info("测试结果：{}", JSONUtil.toJsonStr(user));
    }
    

}