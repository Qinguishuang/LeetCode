package CS_Note.second.designpatterns.proxy.interceptorProxy;

public class Client {
    public static void main(String[] args) {
        Target target = new TargetImpl();
        target.work();

        Target t = (Target) TargetProxy.getProxyObject(target);
        t.work();
    }

}
