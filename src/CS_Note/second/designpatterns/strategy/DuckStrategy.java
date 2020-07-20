package CS_Note.second.designpatterns.strategy;


interface QuackBehavior {
    void quack();
}

class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("quack!");
    }
}

class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("squeak!");
    }
}

/**
 * 将行为进行抽象
 * 定义了算法族， 之间可以互相替换
 */
class Duck {
    private QuackBehavior behavior;

    public void performQuack() {
        if (behavior != null) {
            behavior.quack();
        }
    }

    public void setBehavior(QuackBehavior behavior) {
        this.behavior = behavior;
    }
}

public class DuckStrategy {
    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.setBehavior(new Quack());
        duck.performQuack();

        duck.setBehavior(new Squeak());
        duck.performQuack();
    }
}
