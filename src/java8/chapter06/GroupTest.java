package java8.chapter06;

import java8.chapter04.Dish;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupTest extends Dish {

    public GroupTest(String name, boolean vegetarian, int calories, Type type) {
        super(name, vegetarian, calories, type);
    }

    public static void main(String[] args) {
        Map<Type, List<Dish>> dishesByType = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType)); // Function 分类函数Map
        // System.out.println(dishesByType);

        Map<CaloricLevel, List<Dish>> dishes = menu.stream()
                .collect(Collectors.groupingBy(
                        dish -> {
                            if (dish.getCalories() <= 400)
                                return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700)
                                return CaloricLevel.NORMAL;
                            else
                                return CaloricLevel.FAT;
                        }
                ));
        // System.out.println(dishes);

        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTwo = menu.stream()
                .collect(
                        Collectors.groupingBy(Dish::getType,
                                Collectors.groupingBy(
                                        dish -> {
                                            if (dish.getCalories() <= 400)
                                                return CaloricLevel.DIET;
                                            else if (dish.getCalories() <= 700)
                                                return CaloricLevel.NORMAL;
                                            else
                                                return CaloricLevel.FAT;
                                        }
                                ))
                );
        // System.out.println(dishesByTwo);

        Map<Dish.Type, Long> typesCount = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
        // System.out.println(typesCount);

        Map<Dish.Type, Optional<Dish>> mostC = menu.stream()
                .collect(
                        Collectors.groupingBy(Dish::getType,
                                Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))
                        ));
        // System.out.println(mostC);

        Map<Dish.Type, Dish> mostCa = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(
                                        Comparator.comparingInt(Dish::getCalories)),
                                Optional::get
                        )));
        // System.out.println(mostCa);

        Map<Dish.Type, Integer> totalC = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.summingInt(Dish::getCalories)));
        // System.out.println(totalC);

        Map<Dish.Type, Set<CaloricLevel>> ca = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(
                        dish -> {
                            if (dish.getCalories() <= 400)
                                return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700)
                                return CaloricLevel.NORMAL;
                            else
                                return CaloricLevel.FAT;
                        },
                        Collectors.toCollection(HashSet::new)
                )));
        // System.out.println(ca);



    }


}

enum CaloricLevel {
    DIET, NORMAL, FAT
}
