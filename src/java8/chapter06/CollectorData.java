package java8.chapter06;

import java8.chapter04.Dish;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectorData extends Dish {
    public CollectorData(String name, boolean vegetarian, int calories, Type type) {
        super(name, vegetarian, calories, type);
    }

    public static void main(String[] args) {
        long howManyDishes = menu.stream().collect(Collectors.counting());
        System.out.println(howManyDishes);

        Comparator<Dish> dishComparator = Comparator.comparing(Dish::getCalories);
        Optional<Dish> maxCalorieDish = menu.stream().collect(Collectors.maxBy(dishComparator));
        System.out.println(maxCalorieDish.get());

        int totalCalories = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        Double averageCalories = menu.stream().collect(Collectors.averagingDouble(Dish::getCalories));
        System.out.println(totalCalories);
        System.out.println(averageCalories);

        // 统计count, sum, min, average, ax
        IntSummaryStatistics menuStatistics = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println(menuStatistics);

        String shortMenu = menu.stream().map(Dish::getName).collect(Collectors.joining(" "));
        System.out.println(shortMenu);

        // 两种方式求和: collectors, reducing
        int totalC = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, (i, j) -> i + j));
        Optional<Integer> totalCL = menu.stream().map(Dish::getCalories).reduce(Integer::sum);

        Optional<Dish> mostC = menu.stream().collect(Collectors.reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));


    }

    public static <T> Collector<T, ?, Long> counting() {
        return Collectors.reducing(0L, e -> 1L, Long::sum);
    }
}
