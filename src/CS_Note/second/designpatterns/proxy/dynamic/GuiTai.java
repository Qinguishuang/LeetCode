package CS_Note.second.designpatterns.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class GuiTai implements InvocationHandler {

    private Object o;

    public GuiTai(Object o) {
        this.o = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("销售开始 柜台: " + this.getClass().getSimpleName());
        method.invoke(o, args);
        System.out.println("销售结束");
        return null;
    }
}
