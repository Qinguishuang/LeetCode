package cz;

import java.util.Stack;

public class No042 {
    public int trap(int[] height) {
        if (height == null || height.length <= 1)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) { // 单调栈 [4, 3, 2, 1, 0]  1 单调下降
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int index = stack.pop(); // 顶部元素出栈
                while (!stack.isEmpty() && height[stack.peek()] == height[index]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    int top = stack.peek(); // 左边的那个元素   i 右边那个元素
                    ans += (Math.min(height[top], height[i]) - height[index]) * (i - top - 1);
                }
            }
            stack.add(i);
        }
        return ans;
    }
}
