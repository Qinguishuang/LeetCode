package CS_Note.second.designpatterns.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

//https://blog.csdn.net/briblue/article/details/73928350

/**
 * 动态代理就是要生成一个包装类对象，由于代理的对象是动态的，所以叫动态代理。
 * 由于我们需要增强，这个增强是需要留给开发人员开发代码的，因此代理类不能直接包含被代理对象，
 * 而是一个InvocationHandler，该InvocationHandler包含被代理对象，并负责分发请求给被代理对象，
 * 分发前后均可以做增强。从原理可以看出，JDK动态代理是“对象”的代理。
 */
public class Test {
    public static void main(String[] args) {
        WineA wa = new WineA();
        InvocationHandler iha = new GuiTai(wa);
        SellWine dynamicProxyA = (SellWine) Proxy.newProxyInstance(WineA.class.getClassLoader(), WineA.class.getInterfaces(), iha);
        // dynamicProxyA.sell();

        WineB wb = new WineB();
        InvocationHandler ihb = new GuiTai(wb);
        SellWine dynamicProxyB = (SellWine) Proxy.newProxyInstance(WineB.class.getClassLoader(), WineB.class.getInterfaces(), ihb);
        // dynamicProxyB.sell();

        // dynamicProxyB.s();
        System.out.println(dynamicProxyB.hashCode());


    }
}
