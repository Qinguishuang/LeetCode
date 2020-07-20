package CS_Note.first.designmode.strategy;

/**
 * 定义了一系列算法，并将每个算法封装起来，使它们可以相互替换，
 * 且算法的变化不会影响使用算法的客户。
 */

abstract class Duck {
    FlyBehavior flyBehavior; // 为行为接口声明引用, 没有初始化
    QuackBehavior quackBehavior;

    public Duck() {
    }

    public void display() {
    }

    /**
     * 设置行为
     */
    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void performFly() {
        flyBehavior.fly(); // 委托给行为类
    }

    public void performQuack() {
        quackBehavior.quack(); // 委托给行为类
    }

    public void swim() {
        System.out.println("all docks float");
    }
}

/**
 * 行为类, 所有的飞行行为必须实现该接口
 */
interface FlyBehavior {
    public void fly();
}

/**
 * 飞行行为的实现
 */
class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("i am flying");
    }
}

class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("i can't fly");
    }
}

class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("flying with a rocket");
    }
}

/**
 * 叫行为的接口
 */
interface QuackBehavior {
    public void quack();
}

class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("quack");
    }
}

class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("keep silence");
    }
}

class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("squeak");
    }
}

class MallardDuck extends Duck {
    public MallardDuck() {
        quackBehavior = new Quack(); // 初始化行为, 根据实际的类
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("a real mallard duck");
    }
}

class ModelDuck extends Duck {
    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("a model duck");
    }
}

public class MiniDuckSimulator {
    public static void main(String[] args) {
        // 重载 (静态类型, 参数列表不同)  重写 (实际类型, 继承父类)
        Duck mallard = new MallardDuck();
        mallard.performFly(); // 重写, 根据实际类型运行
        mallard.performQuack();

        Duck modelDuck = new ModelDuck();
        modelDuck.performFly();
        modelDuck.setFlyBehavior(new FlyWithWings());
        modelDuck.performFly();
    }
}