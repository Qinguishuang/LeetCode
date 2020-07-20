package java8.chapter03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {

    public static void main(String[] args) {
        Predicate<String> ps = (String s) -> !s.isEmpty();
        List<String> empty = filter(new ArrayList<>(), ps);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> ans = new ArrayList<>();
        for (T s: list) {
            if (p.test(s)) {
                ans.add(s);
            }
        }
        return ans;
    }
}
