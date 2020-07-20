package CS_Note.second.designpatterns.proxy.interceptorProxy;

public class InterceptorImpl implements Interceptor {

    @Override
    public void doSomething() {
        System.out.println("proxy do something");
    }

}
