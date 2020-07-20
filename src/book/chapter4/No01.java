package book.chapter4;

import java.util.stream.Stream;

public class No01 {
    /**
     * 返回斐波那契数列第n项
     */
    public int fb(int n) {
        if (n == 1)
            return 1;
        else if (n == 2) {
            return 1;
        }
        int f = 1; // 第一项
        int s = 1; // 第二项
        int t = f + s; // 第三项
        for (int i = 3; i <= n; i++) {
            t = f + s;
            f = s;
            s = t;
        }
        return t;
    }

    public static void main(String[] args) {
        No01 n = new No01();
        System.out.println(n.fb(7));

        // 用流生成斐波那契数列
        Stream.iterate(new int[]{0, 1}, x -> new int[]{x[1], x[0] + x[1]})
                .map(x -> x[0])
                .skip(7)
                .limit(1)
                .forEach(System.out::println);
    }
}
