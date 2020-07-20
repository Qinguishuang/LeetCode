package java8.chapter05;

import java8.chapter04.Dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest extends Dish {
    public StreamTest(String name, boolean vegetarian, int calories, Type type) {
        super(name, vegetarian, calories, type);
    }

    public static void main(String[] args) {
        List<Dish> vegetarianMenu = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());
        // System.out.println(vegetarianMenu);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5, 4, 3, 2, 1);
        // numbers.stream()
        //         .filter(i -> i % 2 == 0)
        //         .skip(1)
        //         .distinct() // 去重
        //         .forEach(System.out::println);

        List<Dish> dishes = menu.stream()
                .filter(d -> d.getType() == Type.MEAT)
                .limit(2)
                .collect(Collectors.toList());
        // System.out.println(dishes);

        List<String> words = Arrays.asList("a", "ab", "eat", "word", "tweet");
        List<Integer> wordLen = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        // System.out.println(wordLen);

        List<Integer> squares = numbers.stream()
                .map(x -> x * x)
                .collect(Collectors.toList());
        // System.out.println(squares);

        List<Integer> l1 = Arrays.asList(1, 2, 3);
        List<Integer> l2 = Arrays.asList(4, 5);
        List<int[]> pairs = l1.stream()
                .flatMap(i -> l2.stream().map(j -> new int[]{i, j}))
                .collect(Collectors.toList());
        // pairs.forEach(x -> System.out.println(x[0] + " " + x[1]));

        List<int[]> p = l1.stream()
                .flatMap(i -> l2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j})
                )
                .collect(Collectors.toList());
        // p.forEach(x -> System.out.println(x[0] + " " + x[1]));

        // menu.stream()
        //         .filter(Dish::isVegetarian)
        //         .findAny()
        //         .ifPresent(d -> System.out.println(d.getName()));

        // numbers.stream()
        //         .map(x -> x * x)
        //         .filter(x -> x % 3 == 0)
        //         .findFirst()
        //         .ifPresent(System.out::println);

        int sum = numbers.stream().reduce(1, (i, j) -> i * j);
        // System.out.println(sum);

        Optional<Integer> s = numbers.stream().reduce((a, b) -> a - b);
        // System.out.println(s.get());

        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        // System.out.println(max.get());

        int count = menu.stream()
                .map(d -> 1)
                .reduce(0, Integer::sum);
        long counts = menu.stream().count();

        int calories = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();

        OptionalInt maxC = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        // System.out.println(maxC.orElse(0));


        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                .filter(i -> i % 2 == 0);
        // evenNumbers.forEach(System.out::println);

        Stream<int[]> triples = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                );
        // triples.forEach(t -> System.out.println(t[0] + " " + t[1] + " " + t[2]));

        Stream<double[]> triple = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                        IntStream.range(a, 100)
                                .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                                .filter(t -> t[2] % 1 == 0)
                );
        // triple.forEach(t -> System.out.println(t[0] + " " + t[1] + " " + t[2]));

        // menu.stream().takeWhile(d -> d.getCalories() > 500).forEach(System.out::println);
        // menu.stream().dropWhile(Dish::isVegetarian).forEach(System.out::println);
        // IntStream.iterate(0, n -> n + 1).limit(10).forEach(System.out::println);
        // IntStream.iterate(0, x -> x < 10, x -> x + 2).limit(10).forEach(System.out::println);
    
        Stream<Integer> st = Stream.ofNullable(1);
        // st.forEach(System.out::println);

        var l = new ArrayList<Integer>();
        l.add(9);
        System.out.println(l);
        System.out.println(l.getClass());
        System.out.println(l instanceof List);

    }
}
