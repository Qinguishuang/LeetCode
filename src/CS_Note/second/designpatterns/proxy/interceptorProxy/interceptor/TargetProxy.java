package CS_Note.second.designpatterns.proxy.interceptorProxy.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TargetProxy implements InvocationHandler {

    private Object target;
    private Interceptor interceptor;

    public TargetProxy(Object target, Interceptor interceptor) {
        this.target = target;
        this.interceptor = interceptor;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MethodName methodName = this.interceptor.getClass().getAnnotation(MethodName.class);
        if (methodName == null)
            throw new NullPointerException("拦截器注解方法为空");
        String name = methodName.value();
        if (name.equals(method.getName())) {
            return interceptor.intercept(new Invocation(target, method, args));
        }
        return method.invoke(target, args);

    }

    public static Object getProxyObject(Object target, Interceptor interceptor) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new TargetProxy(target, interceptor));
    }

}
