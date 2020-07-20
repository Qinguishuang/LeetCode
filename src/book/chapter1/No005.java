package book.chapter1;

import java.util.Stack;

public class No005 {
    public void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if (!help.isEmpty() && help.peek() < curr) {
                stack.push(help.pop());
            }
            help.push(curr);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }
}
