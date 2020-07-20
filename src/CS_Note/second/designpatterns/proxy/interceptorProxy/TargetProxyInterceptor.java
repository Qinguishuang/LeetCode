package CS_Note.second.designpatterns.proxy.interceptorProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TargetProxyInterceptor implements InvocationHandler {

    private Object target;
    private Interceptor interceptor;

    public TargetProxyInterceptor(Object target, Interceptor interceptor) {
        this.target = target;
        this.interceptor = interceptor;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        interceptor.doSomething();
        return method.invoke(target, args);
    }

    public static Object getProxyObject(Object target, Interceptor interceptor) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new TargetProxyInterceptor(target, interceptor)
        );
    }
}
