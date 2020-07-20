package lcof.No_61_80;

import java.util.ArrayList;
import java.util.List;

public class No62 {

    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (n > 1) {
            index = (index + m - 1) % n;
            list.remove(index);
            n--;
        }
        return list.get(0);
    }

    /**
     * https://blog.csdn.net/u011500062/article/details/72855826
     * f(N,M)=(f(N−1,M)+M)%N
     * f(N,M)表示，N个人报数，每报到M时杀掉那个人，最终胜利者的编号
     * f(N−1,M)表示，N-1个人报数，每报到M时杀掉那个人，最终胜利者的编号
     */
    public int lastRemaining_(int n, int m) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

    public static void main(String[] args) {
        No62 n = new No62();
        System.out.println(n.lastRemaining(5, 3));
    }
}
