package book.chapter1;

import java.util.Stack;

public class No002<T> {
    private Stack<T> stackPush;
    private Stack<T> stackPop;

    public No002(Stack<T> stackPush, Stack<T> stackPop) {
        this.stackPush = stackPush;
        this.stackPop = stackPop;
    }

    public void pushToPop() {
        while (!stackPush.isEmpty()) {
            stackPop.push(stackPush.pop());
        }
    }

    public void add(T t) {
        stackPush.add(t);
    }

    public T poll() {
        pushToPop();
        return stackPop.pop();
    }

    public T peek() {
        pushToPop();
        return stackPop.peek();
    }
}
