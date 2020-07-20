package CS_Note.second.designpatterns.proxy.interceptorProxy.interceptor;

public class Client {
    public static void main(String[] args) {
        Target target = new TargetImpl();
        target.work();

        System.out.println();

        Interceptor interceptor = new InterceptorImpl();
        Target tt = (Target) TargetProxy.getProxyObject(target, interceptor);
        tt.work();

        Target ta = (Target) new InterceptorImpl().register(target);
        ta.work();

    }
}
