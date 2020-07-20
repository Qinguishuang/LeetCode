package book.chapter1;

import java.util.Stack;

public class No009 {
    /**
     * 计算出每一行直方图, 每一行都计算一次最大面积
     */
    public int maxRecSize(int[][] map) {
        if (map == null || map.length == 0 || map[0].length == 0)
            return 0;
        int maxArea = 0;
        int[] height = new int[map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                // 如果当前值为0 就是0, 否则上次的值+1
                height[j] = (map[i][j] == 0 ? 0 : height[j] + 1);
            }
            maxArea = Math.max(maxArea, maxRecFromBottom(height));
        }
        return maxArea;
    }

    /**
     * 最小栈, 相同也弹出
     * 相同的数, 最后一个计算出来的才是正确的
     */
    public int maxRecFromBottom(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            // 不满足递增就弹出, 计算出 k, j, i 面积为 (i - k - 1) * height[j]
            while (!stack.isEmpty() && stack.peek() >= height[i]) {
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, (i - k - 1) * height[j]);
            }
            stack.push(height[i]);
        }
        while (!stack.isEmpty()) {
            int i = height.length;
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea, (i - k - 1) * height[j]);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        // Arrays.sort();
    }

}
