package CS_Note.second.designpatterns.factorymethod;

/**
 * 抽象产品
 */
interface Product {
    void show();
}

class ConcreteProduct1 implements Product {
    @Override
    public void show() {
        System.out.println("产品1 显示");
    }
}

class ConcreteProduct2 implements Product {
    @Override
    public void show() {
        System.out.println("产品2 显示");
    }
}

interface AbstractFactory {
    Product newProduct();
}

class ConcreteFactory1 implements AbstractFactory {
    @Override
    public Product newProduct() {
        System.out.println("具体工厂1 生成 具体产品1...");
        return new ConcreteProduct1();
    }
}

class ConcreteFactory2 implements AbstractFactory {
    @Override
    public Product newProduct() {
        System.out.println("具体工厂2 生成 具体产品2...");
        return new ConcreteProduct2();
    }
}

public class FactoryMethodTest {
    public static void main(String[] args) {

    }
}
