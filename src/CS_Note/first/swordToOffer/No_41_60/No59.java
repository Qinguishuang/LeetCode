package CS_Note.first.swordToOffer.No_41_60;

import java.util.ArrayList;
import java.util.LinkedList;

public class No59 {

    public static void main(String[] args) {
        No59 n = new No59();
        // {4, 4, 6, 6, 6, 5}
        System.out.println(n.maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3));
    }

    /**
     * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (num == null || num.length == 0 || size <= 0 || num.length < size) {
            return ans;
        }
        LinkedList<Integer> queueMax = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < num.length; i++) {
            while (!queueMax.isEmpty() && num[queueMax.peekLast()] < num[i]) {
                queueMax.pollLast();
            }
            queueMax.add(i);

            if (queueMax.peekFirst() == i - size) {
                queueMax.pollFirst();
            }
            if (i >= size - 1)
                ans.add(num[queueMax.peekFirst()]);
        }
        return ans;
    }
}