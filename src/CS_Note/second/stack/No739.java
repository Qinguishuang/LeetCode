package CS_Note.second.stack;

import java.util.Arrays;
import java.util.Stack;

public class No739 {
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0)
            return new int[]{};
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            // 栈非空, 栈顶元素小, (移除)
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int index = stack.pop();
                ans[index] = i - index;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            ans[stack.pop()] = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        No739 n = new No739();
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(n.dailyTemperatures(T)));
    }
}
