package java8.chapter05;

import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateTest {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("a", "ab", "abc");
        // stream.map(String::toUpperCase).forEach(System.out::println);

        Stream<String> emptyStream = Stream.empty();

        int[] numbers = {2, 3, 5, 7, 11};
        int sum = Arrays.stream(numbers).sum();

        // long uniqueWords = 0;
        // try (
        //         Stream<String> lines = Files.lines(Paths.get(""), Charset.defaultCharset())
        // ) {
        //     uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
        //             .distinct()
        //             .count();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // Stream.iterate(0, x -> x + 2)
        //         .limit(10)
        //         .forEach(System.out::println);

        // Stream.iterate(new int[]{0, 1}, x -> new int[]{x[1], x[0]+x[1]})
        //         .limit(20)
        //         .map(x -> x[0])
        //         .forEach(System.out::println);

        // Stream.generate(Math::random)
        //         .limit(5)
        //         .forEach(System.out::println);

        IntStream ones = IntStream.generate(() -> 1)
                .limit(10);
        IntStream twos = IntStream.generate(new IntSupplier() {
            @Override
            public int getAsInt() {
                return 2;
            }
        });
        ones.forEach(System.out::println);

    }
}
