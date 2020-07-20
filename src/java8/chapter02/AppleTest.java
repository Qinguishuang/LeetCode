package java8.chapter02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 行为参数化(策略模式)
 */

public class AppleTest {
    List<Apple> inventory = new ArrayList<>();
    String s = "apple";

    {
        List<String> list = Arrays.asList("s", "t", "r");
        list.sort(String::compareToIgnoreCase);

        Supplier<Apple> s = Apple::new;
        s.get(); // 产生对象

        Function<Integer, Apple> f = Apple::new;
        f.apply(100); // 传入参数, 产生对象

    }

    // 将行为作为参数传进去
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredict p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    // 匿名内部类
    List<Apple> redApples = filterApples(inventory, new ApplePredict() {
        @Override
        public boolean test(Apple apple) {
            return "red".equals(apple.getColor());
        }
    });

    // lambda 表达式
    List<Apple> list = filterApples(inventory, (Apple apple) -> "red".equals(apple.getColor()));


    List<Integer> weights = Arrays.asList(1, 2, 3, 4);
    List<Apple> l = map(weights, Apple::new);

    /**
     * 传入T, 返回R
     * Function<T, R>   T -> R
     */
    public static List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
        List<Apple> res = new ArrayList<>();
        for (Integer i : list) {
            res.add(f.apply(i));
        }
        return res;
    }

    /**
     * 穿进去T, U 返回R
     * BiFunction<T, U, R>   (T, U) -> R
     */
    BiFunction<String, Integer, Apple> bf = Apple::new;
    Apple a = bf.apply("green", 12);

    BiFunction<String, Integer, Apple> biFunction = (color, weight) -> new Apple(color, weight);
    Apple s2 = biFunction.apply("green", 123);

    static Map<String, Function<Integer, Fruit>> map = new HashMap<>();

    static {
        map.put("apple", Apple::new);
        map.put("orange", Orange::new);
    }

    public static Fruit giveMeFruit(String fruit, Integer weight) {
        return map.get(fruit.toLowerCase()).apply(weight);
    }

}

class Fruit {

}

class Orange extends Apple {
    public Orange(String color) {
        super(color);
    }

    public Orange(int weight) {
        super(weight);
    }
}

class Apple extends Fruit {
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


interface ApplePredict {
    boolean test(Apple apple);
}

class AppleHeavyWeightPredicate implements ApplePredict {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}

class AppleGreenColorPredicate implements ApplePredict {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}

interface AppleFormatter {
    String accept(Apple apple);
}

class AppleFancyFormatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
        String characteristic = apple.getWeight() > 150 ? "heavy" : "light";
        return "A " + characteristic + " " + apple.getColor() + " apple";
    }
}