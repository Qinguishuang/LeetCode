package lcof.No_21_40;

import java.util.Stack;

public class No31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length)
            return false;
        Stack<Integer> tmp = new Stack<>();
        int popNum = 0;
        for (int i = 0; i < pushed.length; i++) {
            if (pushed[i] != popped[popNum]) {
                tmp.add(pushed[i]);
            } else {
                popNum++;
                while (tmp.peek() == popped[popNum]) {
                    tmp.pop();
                    popNum ++;
                }
            }
        }
        while (!tmp.isEmpty()) {
            if (tmp.pop() != popped[popNum++])
                return false;
        }
        return true;
    }
}
