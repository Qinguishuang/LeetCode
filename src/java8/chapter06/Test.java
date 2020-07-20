package java8.chapter06;

import java8.chapter04.Dish;

import java.util.Comparator;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test extends Dish {

    public Test(String name, boolean vegetarian, int calories, Type type) {
        super(name, vegetarian, calories, type);
    }

    public static void main(String[] args) {
        Comparator<Dish> calories = Comparator.comparing(Dish::getCalories);

        Optional<Dish> maxCalories = menu.stream()
                .collect(Collectors.maxBy(calories));
        // maxCalories.ifPresent(System.out::println);

        int totalC = menu.stream()
                .collect(Collectors.summingInt(Dish::getCalories));
        // System.out.println(totalC);

        IntSummaryStatistics statistics = menu.stream()
                .collect(Collectors.summarizingInt(Dish::getCalories));
        // System.out.println(statistics);

        String shortName = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.joining(", "));
        // System.out.println(shortName);

        int total = menu.stream()
                .collect(Collectors.reducing(0, Dish::getCalories, (i, j) -> i + j));
        // System.out.println(total);

        Optional<Dish> t = menu.stream()
                .collect(Collectors.reducing((x, y) -> x.getCalories() > y.getCalories() ? x : y));
        // System.out.println(t.get());


        Map<CaloricLevel, List<Dish>> dishesByC = menu.stream()
                .collect(
                        Collectors.groupingBy(
                                dish -> {
                                    if (dish.getCalories() <= 400)
                                        return CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700)
                                        return CaloricLevel.NORMAL;
                                    else
                                        return CaloricLevel.FAT;
                                }
                        )
                );
        // System.out.println(dishesByC);

        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesTypeCa = menu.stream()
                .collect(
                        Collectors.groupingBy(Dish::getType,
                                Collectors.groupingBy(dish -> {
                                    if (dish.getCalories() <= 400)
                                        return CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700)
                                        return CaloricLevel.NORMAL;
                                    else
                                        return CaloricLevel.FAT;
                                }))
                );
        // System.out.println(dishesTypeCa);

        Map<Dish.Type, Dish> mostCT = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)),
                                Optional::get)));
        // System.out.println(mostCT);

        Map<Dish.Type, Set<CaloricLevel>> caloricT = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType,
                        Collectors.mapping(dish -> {
                            if (dish.getCalories() <= 400)
                                return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700)
                                return CaloricLevel.NORMAL;
                            else
                                return CaloricLevel.FAT;
                        }, Collectors.toCollection(HashSet::new))));
        // System.out.println(caloricT);

        Map<Boolean, List<Dish>> partitionedMenu = menu.stream()
                .collect(Collectors.partitioningBy(Dish::isVegetarian));
        // System.out.println(partitionedMenu);

        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishT = menu.stream()
                .collect(Collectors.partitioningBy(Dish::isVegetarian,
                        Collectors.groupingBy(Dish::getType)));
        // System.out.println(vegetarianDishT);

        Map<Boolean, Dish> mostCPV = menu.stream()
                .collect(Collectors.partitioningBy(Dish::isVegetarian,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)),
                                Optional::get)));
        // System.out.println(mostCPV);

        System.out.println(partitionPrimes(20));


    }

    public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.range(2, n).boxed()
                .collect(Collectors.partitioningBy(x -> isPrime(x)));
    }

    public static boolean isPrime(int i) {
        int root = (int) Math.sqrt(i);
        return IntStream.range(2, root)
                .noneMatch(x -> i % x == 0);
    }
}
