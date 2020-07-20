package CS_Note.second.designpatterns.proxy.interceptorProxy.interceptor;

import java.lang.reflect.InvocationTargetException;

/**
 * 拦截器完成 调用增强方法和原始方法
 */
public interface Interceptor {

    Object register(Object target);

    Object intercept(Invocation invocation) throws InvocationTargetException, IllegalAccessException;
}
