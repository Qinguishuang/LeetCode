package CS_Note.first.designmode.builder;

/**
 * 建造者(生成器)
 * 封装一个对象的构造过程, 将一个复杂对象封装成多个简单对象, 按步骤构造
 * <p>
 * 该模式的主要优点如下：
 * 各个具体的建造者相互独立，有利于系统的扩展。
 * 客户端不必知道产品内部组成的细节，便于控制细节风险。
 * <p>
 * 其缺点如下：
 * 产品的组成部分必须相同，这限制了其使用范围。
 * 如果产品的内部变化复杂，该模式会增加很多的建造者类。
 */
public class Client {
    /**
     * 指挥者
     * 抽象建造者
     * 具体建造者
     * 产品
     * 客户
     */
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product product = director.construct();
        product.show();
    }
}

/**
 * 产品
 * 包含多个构件
 */
class Product {
    private String partA;
    private String partB;
    private String partC;

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    public void show() {
        System.out.println("this is the produce: " + partA + " " + partB + " " + partC);
    }
}

/**
 * 抽象建造者
 */
abstract class Builder {
    // 创建产品
    protected Product product = new Product();

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract void buildPartC();

    // 返回构造好的产品
    public Product getResult() {
        return product;
    }

}


/**
 * 具体建造者
 */
class ConcreteBuilder extends Builder {

    @Override
    public void buildPartA() {
        product.setPartA("构造 partA");
    }

    @Override
    public void buildPartB() {
        product.setPartB("构造 partB");
    }

    @Override
    public void buildPartC() {
        product.setPartC("构造 partC");
    }
}

/**
 * 指挥者
 */
class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Product construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}