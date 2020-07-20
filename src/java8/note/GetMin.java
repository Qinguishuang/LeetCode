package java8.note;

public class GetMin {
    /**
     * 泛型获取数组最小值
     * 方法接受Number子类, 实现了Comparable接口
     */
    private static <T extends Number & Comparable<? super T>> T min(T[] value) {
        if (value == null || value.length == 0) {
            return null;
        }
        T min = value[0];
        for (int i = 1; i < value.length; i++) {
            if (min.compareTo(value[i]) > 0) {
                min = value[i];
            }
        }
        return min;
    }
}
