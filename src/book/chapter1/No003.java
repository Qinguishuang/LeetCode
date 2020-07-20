package book.chapter1;

import java.util.Stack;

public class No003 {

    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int tmp = stack.pop();
        if (stack.isEmpty()) {
            return tmp;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(tmp);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int tmp = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(tmp);
    }

}
