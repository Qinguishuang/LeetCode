package CS_Note.first.search;

import java.util.ArrayList;
import java.util.List;

public class No077 {
    /**
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     */
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) {
            return ans;
        }
        List<Integer> tmp = new ArrayList<>();
        backTracing(tmp, 1, n, k);
        return ans;
    }

    public void backTracing(List<Integer> list, int i, int n, int k) {
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j <= n; j++) {
            list.add(j);
            backTracing(list, j + 1, n, k);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        No077 n = new No077();
        System.out.println(n.combine(4, 2));

    }

}
