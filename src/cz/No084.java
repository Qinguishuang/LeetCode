package cz;

import java.util.Stack;

public class No084 {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length <= 1)
            return 0;
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) { // 单调递增
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                int h = stack.pop();
                ans = Math.max(ans, heights[h] * (i - stack.peek() - 1));
            }
            stack.add(i);
        }
        while (stack.peek() != -1) {
            ans = Math.max(ans, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }

        return ans;
    }
}
