package cz;

import java.nio.channels.Pipe;
import java.util.Stack;

public class No946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();
        // int push = 0;
        int pop = 0;
        for (int i = 0; i < pushed.length; i++) {
            s.push(pushed[i]);
            while (!s.isEmpty() && s.peek() == popped[pop]) {
                s.pop();
                pop ++;
            }
        }
        return s.isEmpty();
    }
}
