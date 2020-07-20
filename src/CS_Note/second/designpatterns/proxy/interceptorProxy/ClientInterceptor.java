package CS_Note.second.designpatterns.proxy.interceptorProxy;

public class ClientInterceptor {
    public static void main(String[] args) {
        Target target = new TargetImpl();
        target.work();

        System.out.println();

        Interceptor interceptor = new InterceptorImpl();
        Target t = (Target) TargetProxyInterceptor.getProxyObject(target, interceptor);
        t.work();

        System.out.println();

        Interceptor it = new Interceptor() {
            @Override
            public void doSomething() {
                System.out.println("change a interceptor");
            }
        };
        Target t2 = (Target) TargetProxyInterceptor.getProxyObject(target, it);
        t2.work();
    }
}
