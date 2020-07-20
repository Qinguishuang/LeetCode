package CS_Note.second.designpatterns.proxy.interceptorProxy.interceptor;

public class TargetImpl implements Target {

    @Override
    public void work() {
        System.out.println("target work 被代理的方法被调用");
    }
}
