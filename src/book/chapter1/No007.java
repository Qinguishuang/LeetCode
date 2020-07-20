package book.chapter1;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 依次输出滑动窗口最大值
 * 双端队列实现
 * - 只保留当前滑动窗口中有的元素的索引。
 * - 移除比当前元素小的所有元素，它们不可能是最大的。
 */
public class No007 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k < 1 || nums.length < k) {
            return new int[0];
        }
        LinkedList<Integer> max = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            // 移除比当前元素小的所有元素，它们不可能是最大的
            while (!max.isEmpty() && nums[max.peekLast()] < nums[i]) {
                max.pollLast();
            }
            max.addLast(i);
            // 判断队列头元素是否过期
            if (max.peekFirst() == i - k) {
                max.pollFirst();
            }
            // 大于窗口长度了, 要记录最大值
            if (i >= k - 1) {
                res[index++] = nums[max.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        No007 n = new No007();
        System.out.println(Arrays.toString(n.maxSlidingWindow(new int[]{4, 3, 5, 4, 3, 3, 6, 7}, 3)));
    }
}
