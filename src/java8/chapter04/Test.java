package java8.chapter04;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 流:
 * 数据源, 中间操作, 终端操作
 */
public class Test extends Dish {
    public Test(String name, boolean vegetarian, int calories, Type type) {
        super(name, vegetarian, calories, type);
    }

    // 流式编程
    List<String> threeHighCaloricDishNames = menu.stream()
            .filter(d -> d.getCalories() > 300)
            .map(Dish::getName)
            .limit(3)
            .collect(Collectors.toList());


    public static void main(String[] args) {
        List<String> name = menu.stream()
                .filter(d -> {
                    System.out.println(d.getName());
                    return d.getCalories() > 300;
                })
                .map(d -> {
                    System.out.println(d.getName());
                    return d.getName();
                })
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(name);
        menu.forEach(System.out::println);
    }
}
