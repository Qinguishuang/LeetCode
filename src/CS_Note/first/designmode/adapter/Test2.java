package CS_Note.first.designmode.adapter;

/**
 * 把一个类的接口转换为另一个类的接口
 * <p>
 * 客户端通过适配器可以透明地调用目标接口。
 * 复用了现存的类，程序员不需要修改原有代码而重用现有的适配者类。
 * 将目标类和适配者类解耦，解决了目标类和适配者类接口不一致的问题。
 * <p>
 * 其缺点是：对类适配器来说，更换适配器的实现过程比较复杂。
 */

// 对象适配器
// 将usb转成typeC
public class Test2 {
    public static void main(String[] args) {
        TypeC typeC = new TypeCImpl();
        Usb usb = new Adapters(typeC);
        usb.isUsb();
    }
}

class Adapters implements Usb {

    private TypeC typeC;

    public Adapters(TypeC typeC) {
        this.typeC = typeC;
    }

    @Override
    public void isUsb() {
        typeC.isTypeC();
    }
}