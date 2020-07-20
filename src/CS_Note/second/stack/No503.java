package CS_Note.second.stack;

import java.util.Arrays;
import java.util.Stack;

public class No503 {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0)
            return new int[]{};
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length * 2; i++) {
            int index = i % nums.length;
            // 找到了下一个更大的元素
            while (!stack.isEmpty() && nums[stack.peek()] < nums[index]) {
                ans[stack.pop()] = nums[index];
            }
            stack.push(index);
        }
        // while (!stack.isEmpty()) {
        //     if (ans[stack.peek()] != 0)
        //         ans[stack.pop()] = -1;
        // }
        return ans;
    }

    public static void main(String[] args) {
        No503 n = new No503();
        int[] nums = {1, 2, 1};
        System.out.println(Arrays.toString(n.nextGreaterElements(nums)));
    }
}
