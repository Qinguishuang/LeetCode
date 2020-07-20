package CS_Note.second.designpatterns.adapter;

public class AdapterTest {
    public static void main(String[] args) {
        MallardDuck md = new MallardDuck(); // 创建一只鸭子
        WildTurkey wt = new WildTurkey(); // 创建一只火鸡

        Duck turkeyAdapter = new TurkeyAdapter(wt); // 适配器伪装成鸭子

        wt.fly();
        wt.gobble();

        testDuck(md);
        testDuck(turkeyAdapter);
    }

    public static void testDuck(Duck duck) {
        duck.fly();
        duck.quack();
    }
}
