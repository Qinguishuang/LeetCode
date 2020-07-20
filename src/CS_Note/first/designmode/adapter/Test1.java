package CS_Note.first.designmode.adapter;

import java.util.Arrays;

/**
 * 把一个类的接口转换为另一个类的接口
 * <p>
 * 客户端通过适配器可以透明地调用目标接口。
 * 复用了现存的类，程序员不需要修改原有代码而重用现有的适配者类。
 * 将目标类和适配者类解耦，解决了目标类和适配者类接口不一致的问题。
 * <p>
 * 其缺点是：对类适配器来说，更换适配器的实现过程比较复杂。
 */

// 类适配器
// usb转成typeC
public class Test1 {
    public static void main(String[] args) {
        Usb usb = new Adapter();
        usb.isUsb();
        Arrays.asList();
    }
}

interface Usb {
    void isUsb();
}


interface TypeC {
    void isTypeC();
}

class TypeCImpl implements TypeC {

    @Override
    public void isTypeC() {
        System.out.println("type c");
    }
}

class Adapter extends TypeCImpl implements Usb {

    @Override
    public void isUsb() {
        isTypeC();
    }
}