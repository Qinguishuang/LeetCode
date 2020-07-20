package java8.chapter05;

import java8.chapter04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MenuTest extends Dish {

    public MenuTest(String name, boolean vegetarian, int calories, Type type) {
        super(name, vegetarian, calories, type);
    }

    public static void main(String[] args) {
        // 筛选 过滤 filter
        List<Dish> dishes = menu.stream()
                .filter(d -> d.getType() == Type.MEAT)
                .limit(2)
                .collect(Collectors.toList());
        // System.out.println(dishes);

        // 映射 map
        List<Integer> l = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());
        // System.out.println(l);

        // 扁平化 flatMap
        // 把流中的每一个值都转化成流, 把所有的流连接起来成为一个流
        List<String> ls = Arrays.asList("hello", "world");
        List<String> lis = ls.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        // System.out.println(lis);

        List<Integer> lint = Arrays.asList(1, 2, 3, 4);
        List<Integer> squares = lint.stream()
                .map(x -> x * x)
                .collect(Collectors.toList());
        // System.out.println(squares);

        // 组合两个数组  Stream<Stream<Integer[]>>
        List<Integer> num1 = Arrays.asList(1, 2, 3);
        List<Integer> num2 = Arrays.asList(4, 5);
        List<int[]> lints = num1.stream()
                .flatMap(i -> num2.stream().map(j -> new int[]{i, j}))
                .collect(Collectors.toList());
        List<int[]> lints2 = num1.stream()
                .flatMap(i -> num2.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[]{i, j}))
                .collect(Collectors.toList());
        // System.out.println();


        // 谓词匹配 至少一个
        boolean isVe = menu.stream().anyMatch(Dish::isVegetarian);
        // 全部匹配
        boolean isHealthy = menu.stream().allMatch(d -> d.getCalories() < 1000);
        // 全部不匹配
        boolean isHea = menu.stream().noneMatch(d -> d.getCalories() >= 1000);
        // 查找元素
        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(d -> System.out.println(d.getName()));

        // Option<T> 容器类
        List<Integer> someNum = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Optional<Integer> firstNum = someNum.stream()
                .map(x -> x * x)
                .filter(x -> x % 3 == 0)
                .findFirst();
        // firstNum.ifPresent(System.out::println);

        // reduce规约
        int sum = someNum.stream().reduce(0, Integer::sum);
        int product = someNum.stream().reduce(1, (a, b) -> a * b);
        // 返回值可能不存在
        Optional<Integer> sumNum = someNum.stream().reduce((a, b) -> a + b);
        Optional<Integer> maxNum = someNum.stream().reduce((a, b) -> a > b ? a : b);
        Optional<Integer> minNum = someNum.stream().reduce(Integer::min);

        System.out.println(sum);
        System.out.println(product);
        System.out.println(sumNum.get());
        System.out.println(maxNum.get());
        System.out.println(minNum.get());

        // 统计流中元素个数
        int count = menu.stream()
                .map(d -> 1)
                .reduce(0, (a, b) -> a + b);

        // 求和
        int totalCa = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));
        int totalCa_ = menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();


    }
}
