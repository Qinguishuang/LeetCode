package java8.chapter05;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStream {
    public static void main(String[] args) {
        // 由值创建流
        Stream<String> stream = Stream.of("a", "b", "c");
        stream.map(String::toUpperCase).forEach(System.out::println);
        Stream<String> emptyStream = Stream.empty();

        // 由数组创建流
        int[] numbers = {1, 2, 3, 4, 5};
        int sum = Arrays.stream(numbers).sum();

        // 由文件生成流
        // 看一个文件中包含多少个不相同的词
        long uniqueWords = 0;
        try (
                Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset());
        ) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
        } catch (IOException e) {
            // e.printStackTrace();
        }

        // 由函数生成流 (初始值, 产生的新值)
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        // 流 生成斐波那契数列, iterator 后面生成的要依靠前面的
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);

        // (生成函数)
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        IntStream ones = IntStream.generate(() -> 1);
        ones.limit(10).forEach(System.out::println);

        IntStream twos = IntStream.generate(new IntSupplier() {
            @Override
            public int getAsInt() {
                return 2;
            }
        });
        twos.limit(10).forEach(System.out::println);
    }
}
