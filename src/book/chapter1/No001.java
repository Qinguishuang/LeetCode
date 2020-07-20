package book.chapter1;

import java.util.Stack;

public class No001 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public No001(Stack<Integer> stackData, Stack<Integer> stackMin) {
        this.stackData = stackData;
        this.stackMin = stackMin;
    }

    public void push(int num) {
        stackData.push(num);
        if (stackMin.size() == 0) {
            stackMin.push(num);
        } else {
            stackMin.push(Math.min(num, stackMin.peek()));
        }
    }

    public int pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        stackMin.pop();
        return stackData.pop();
    }

    public int getMin() {
        return stackMin.peek();
    }

}
