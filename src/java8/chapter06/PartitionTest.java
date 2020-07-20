package java8.chapter06;

import java8.chapter04.Dish;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PartitionTest extends Dish {
    public PartitionTest(String name, boolean vegetarian, int calories, Type type) {
        super(name, vegetarian, calories, type);
    }


    public static void main(String[] args) {
        Map<Boolean, List<Dish>> partMenu = menu.stream()
                .collect(Collectors.partitioningBy(Dish::isVegetarian));
        // System.out.println(partMenu);

        Map<Boolean, Map<Dish.Type, List<Dish>>> v = menu.stream()
                .collect(
                        Collectors.partitioningBy(Dish::isVegetarian,
                                Collectors.groupingBy(Dish::getType))
                );
        // System.out.println(v);

        Map<Boolean, Dish> mostV = menu.stream()
                .collect(Collectors.partitioningBy(Dish::isVegetarian,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(
                                        Comparator.comparingInt(Dish::getCalories)
                                ),
                                Optional::get
                        )));
        // System.out.println(mostV);

        // 区分质数, 非质数
        System.out.println(partPrimes(20));

    }

    public static Map<Boolean, List<Integer>> partPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(Collectors.partitioningBy(PartitionTest::isPrime));
    }

    public static boolean isPrime(int i) {
        return IntStream.rangeClosed(2, i).noneMatch(x -> i % x == 0);
    }
}
