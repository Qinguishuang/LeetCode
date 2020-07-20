package CS_Note.first.stack;

import java.util.Stack;

public class No155 {
    Stack<Integer> s = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public No155() {

    }

    public void push(int x) {
        s.add(x);
        if (x < min.peek()) {
            min.push(min.peek());
        } else {
            min.push(x);
        }
    }

    public void pop() {
        s.pop();
        min.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
