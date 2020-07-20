package java8.chapter07;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        System.out.println(measureSumPerf(Test::parallelSum, 1_000_000));
        System.out.println(measureSumPerf(Test::sequentialSum, 1_000_000));
        System.out.println(measureSumPerf(Test::rangeSum, 1_000_000));
        System.out.println(measureSumPerf(Test::forSum, 1_000_000));


    }

    public static long sequentialSum(long n) {
        // return LongStream.rangeClosed(0, n).sum();
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    // 并行求和
    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> (i + 1))
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    public static long rangeSum(long n) {
        return LongStream.rangeClosed(0, n).parallel().reduce(0L, Long::sum);
    }

    public static long forSum(long n) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += i;
        }
        return ans;
    }

    public static long measureSumPerf(Function<Long, Long> adder, long n) {
        long fast = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            // System.out.println("result: " + sum);
            if (duration < fast)
                fast = duration;
        }
        return fast;
    }
}
