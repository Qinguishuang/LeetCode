package CS_Note.second.designpatterns.adapter;

import java.util.Iterator;

/**
 * 实现希望看到的类型
 */
public class TurkeyAdapter implements Duck {
    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    /**
     * 伪装自己
     */
    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        turkey.fly();
        turkey.fly();
        turkey.fly();
    }
}

interface Duck {
    public void quack();

    public void fly();
}

class MallardDuck implements Duck {

    @Override
    public void quack() {
        System.out.println("quack");
    }

    @Override
    public void fly() {
        System.out.println("flying");
    }
}


interface Turkey {
    public void gobble();

    public void fly();
}

class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("gobble gobble");
    }

    @Override
    public void fly() {
        System.out.println("fly a short instance");
    }
}