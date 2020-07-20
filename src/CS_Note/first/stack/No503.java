package CS_Note.first.stack;

import java.util.Arrays;
import java.util.Stack;

public class No503 {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0)
            return nums;
        int[] max = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && nums[i % nums.length] >= s.peek()) {
                s.pop();
            }
            max[i % nums.length] = s.isEmpty() ? -1 : s.peek();
            s.add(nums[i % nums.length]);
        }
        return max;
    }

    public static void main(String[] args) {
        No503 n = new No503();
        int[] nums = {2, 1, 2, 4, 3};
        Arrays.toString(n.nextGreaterElements(nums));
    }
}
