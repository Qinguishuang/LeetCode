package CS_Note.first.designmode.decorator;

/**
 * 不改变当前对象结构的情况下, 给对象增加功能
 * <p>
 * 采用装饰模式扩展对象的功能比采用继承方式更加灵活。
 * 可以设计出多个不同的具体装饰类，创造出多个不同行为的组合。
 * <p>
 * 其主要缺点是：装饰模式增加了许多子类，如果过度使用会使程序变得很复杂。
 * <p>
 * 抽象构件
 * 具体构件
 * 抽象装饰
 * 具体装饰
 */
public class Test {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        component.operation();
        Component d = new ConcreteDecorator(component);
        d.operation();
    }
}

// 抽象构件
interface Component {
    void operation();
}

//具体构件
class ConcreteComponent implements Component {

    public ConcreteComponent() {
        System.out.println("具体构件初始化");
    }

    @Override
    public void operation() {
        System.out.println("调用具体构件的operation方法");
    }
}

// 抽象装饰
class Decorator implements Component {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}

// 具体装饰
class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(Component component) {
        super(component);
    }

    public void operator() {
        super.operation();
        addFunction();
    }

    public void addFunction() {
        System.out.println("具体装饰为 构件 增加功能");
    }
}