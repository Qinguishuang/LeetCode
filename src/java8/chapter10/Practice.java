package java8.chapter10;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Practice {
    private static Map<String, Object> map = new HashMap<>();

    public static void main(String[] args) {
        Optional<Object> value = Optional.ofNullable(map.get("key"));
    }

    public static Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

}
