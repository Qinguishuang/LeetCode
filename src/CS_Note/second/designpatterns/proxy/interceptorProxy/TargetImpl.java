package CS_Note.second.designpatterns.proxy.interceptorProxy;

public class TargetImpl implements Target {

    @Override
    public void work() {
        System.out.println("target work");
    }
}
