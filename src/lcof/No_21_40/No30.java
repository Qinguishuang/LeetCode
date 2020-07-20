package lcof.No_21_40;

import java.util.Stack;

public class No30 {
    Stack<Integer> s = new Stack<>();
    Stack<Integer> min = new Stack<>();

    /**
     * initialize your data structure here.
     */
    public No30() {

    }

    public void push(int x) {
        s.push(x);
        if (min.isEmpty())
            min.push(x);
        else {
            if (x < min.peek()) {
                min.push(x);
            } else {
                min.push(min.peek());
            }
        }
    }

    public void pop() {
        s.pop();
        min.pop();
    }

    public int top() {
        return s.peek();
    }

    public int min() {
        return min.peek();
    }
}
