package java8.chapter04;

import java.util.List;
import java.util.stream.Collectors;

public class StreamTest extends Dish {
    public StreamTest(String name, boolean vegetarian, int calories, Type type) {
        super(name, vegetarian, calories, type);
    }

    public static void main(String[] args) {
        List<String> threeHighCaloricDishNames =
                menu.stream()
                        .filter(d -> d.getCalories() > 300)
                        .map(Dish::getName)
                        .limit(3)
                        .collect(Collectors.toList());
        // System.out.println(threeHighCaloricDishNames);

        List<String> names = menu.stream()
                .filter(d -> {
                    System.out.println("filter: " + d.getName());
                    return d.getCalories() > 300;
                })
                .map(d -> {
                    System.out.println("map: " + d.getName());
                    return d.getName();
                })
                .limit(3)
                .collect(Collectors.toList());
        // System.out.println(names);

        menu.forEach(System.out::println);
    }
}
