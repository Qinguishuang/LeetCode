package CS_Note.first.stack;

import java.util.Stack;

public class No739 {
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0)
            return null;
        int[] max = new int[T.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!s.isEmpty() && T[i] > T[s.peek()]) {
                int index = s.pop();
                max[index] = i - index;
            }
            s.add(i);
        }
        return max;
    }
}
