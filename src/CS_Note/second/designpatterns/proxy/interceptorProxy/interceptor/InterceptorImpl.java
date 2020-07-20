package CS_Note.second.designpatterns.proxy.interceptorProxy.interceptor;

import java.lang.reflect.InvocationTargetException;

@MethodName("work")
public class InterceptorImpl implements Interceptor {
    @Override
    public Object register(Object target) {
        return TargetProxy.getProxyObject(target, this);
    }

    @Override
    public Object intercept(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        return invocation.proceed();
    }

}
