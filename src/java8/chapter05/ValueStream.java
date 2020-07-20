package java8.chapter05;

import java8.chapter04.Dish;

import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ValueStream extends Dish {
    public ValueStream(String name, boolean vegetarian, int calories, Type type) {
        super(name, vegetarian, calories, type);
    }

    public static void main(String[] args) {

        // Stream<Dish>  ->  IntStream
        int calories = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();

        // 数值流 -> 对象流 (装箱)
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> s = intStream.boxed();

        // 默认值
        OptionalInt maxOI = menu.stream().mapToInt(Dish::getCalories).max();
        System.out.println(maxOI.orElse(1));
        // System.out.println(maxOI.getAsInt());

        // 不包含结束值
        IntStream even = IntStream.rangeClosed(0, 100).filter(i -> i % 2 == 0);
        System.out.println(even.count());

        // 求出 1 - 100 所有的勾股数
        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100)
                .boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));

        Stream<double[]> pythagoreanTriples2 = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                        .filter(t -> t[2] % 1 == 0));

        // 输出流中元素
        // pythagoreanTriples.forEach(t -> System.out.println(t[0] + " " + t[1] + " " + t[2]));
        pythagoreanTriples2.forEach(t -> System.out.println(t[0] + " " + t[1] + " " + t[2]));
    }
}
