package java8.chapter03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class AppleTest {
    static List<Apple> inventory = new ArrayList<>();

    static {
        inventory.add(new Apple(123, "red"));
        inventory.add(new Apple(234, "green"));
        inventory.add(new Apple(345, "blue"));

    }

    public static void main(String[] args) {
        // 传递代码
        inventory.sort(new AppleComparator());

        // 匿名内部类
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });

        // lambda表达式
        inventory.sort((o1, o2) -> o1.getWeight() - o2.getWeight());
        inventory.sort(Comparator.comparing((a) -> a.getWeight()));

        // 方法引用
        inventory.sort(Comparator.comparing(Apple::getWeight));
        inventory.sort(Comparator.comparing(Apple::getColor).reversed());
        // 比较器链  复合
        inventory.sort(Comparator.comparing(Apple::getColor).thenComparing(Apple::getWeight));

        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g); // g(f(x)) 先算f 在算g
        Function<Integer, Integer> j = f.compose(g); // f(g(x)) 先算g 在算f
        int i = h.apply(3);
        int k = j.apply(3);
        System.out.println(i);
        System.out.println(k);


    }
}


class AppleComparator implements Comparator<Apple> {
    @Override
    public int compare(Apple o1, Apple o2) {
        return o1.getWeight() - o2.getWeight();
    }
}


class Apple {
    private String color;
    private int weight;

    public Apple() {
    }

    public Apple(int weight) {
        this.weight = weight;
    }

    public Apple(String color) {
        this.color = color;
    }

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}