package CS_Note.second.designpatterns.proxy.interceptorProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TargetProxy implements InvocationHandler {

    private Object target; // 被代理对象

    public TargetProxy(Object target) {
        this.target = target; // 被代理对象传过来
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理增强"); // 代理增强
        return method.invoke(target, args); // 原来的方法
    }

    public static Object getProxyObject(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new TargetProxy(target)
        );
    }
}
