package java8.chapter13;

import java.io.File;
import java.io.FileFilter;
import java.util.function.DoubleUnaryOperator;

public class Test {
    public static void main(String[   ] args) {
        File[] hiddenFiles = new File(".").listFiles(File::isHidden);

    }

    public static DoubleUnaryOperator curriedConverter(double f, double b) {
        return (double x) -> x * f + b;
    }


    // public static List<List<Integer>> subSet(List<Integer> list) {
    //     if (list.isEmpty()) {
    //         List<List<Integer>> ans = new ArrayList<>();
    //         ans.add(Collections.emptyList());
    //         return ans;
    //     }
    //
    //     Integer first = list.get(0);
    //     List<Integer> rest = list.subList(1, list.size());
    //
    //     List<List<Integer>> subans = subSet(rest);
    //     List<List<Integer>> subans2 = insertAll(first, subans);
    //
    //     return concat(subans, subans2);
    //
    // }
}
