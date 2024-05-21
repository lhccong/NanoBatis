package com.cong.nanobatis;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 映射器代理
 *
 * @author cong
 * @date 2024/05/21
 */
public class MapperProxy<T> implements InvocationHandler, Serializable {

    private static final long serialVersionUID = -469152714367086161L;

    //所有的数据库语句操作，都是通过接口名称+方法名称作为key，操作作为逻辑的方式进行使用的
    private final Map<String, String> sqlSession;

    private final Class<T> mapperInterface;

    public MapperProxy(Map<String, String> sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //注意如果是 Object 提供的 toString、hashCode 等方法是不需要代理执行的，所以添加 Object.class.equals(method.getDeclaringClass()) 判断。
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        } else {
            //获取接口名称+方法名称作为key
            return "没想到吧！！你被我代理啦~~~~~！" + sqlSession.get(mapperInterface.getName() + "." + method.getName());
        }
    }
}
