package lcof.No_41_60;

import java.util.Deque;
import java.util.LinkedList;

public class No59 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> max = new LinkedList<>();
        int[] ans = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!max.isEmpty() && nums[max.peekLast()] < nums[i]) {
                max.pollLast();
            }
            max.addLast(i);
            if (max.peekFirst() == i - k) {
                max.pollFirst();
            }
            if (i >= k - 1) {
                ans[index++] = nums[max.peekFirst()];
            }
        }
        return ans;
    }
}
