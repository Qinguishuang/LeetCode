package java8.chapter03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReference {
    public static void main(String[] args) {
        List<String> str = Arrays.asList("a", "b", "c");
        str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));

        str.sort(String::compareToIgnoreCase);

        Function<String, Integer> sTi = s -> Integer.parseInt(s);
        Function<String, Integer> sTiM = Integer::parseInt;

        BiPredicate<List<String>, String> c = List::contains;

        Supplier<Apple> apple = Apple::new;
        Supplier<Apple> apple2 = () -> new Apple(); // 创建无参对象

        Function<Integer, Apple> appleFunction = Apple::new; // 创建有参对象


        List<Integer> list = Arrays.asList(1, 2, 3);
        List<Apple> apples = map(list, Apple::new);

        BiFunction<String, Integer, Apple> bf = Apple::new;
        Apple a = bf.apply("a", 2);
    }

    public static List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
        List<Apple> ans = new ArrayList<>();
        for (Integer i : list) {
            ans.add(f.apply(i));
        }
        return ans;
    }

}
