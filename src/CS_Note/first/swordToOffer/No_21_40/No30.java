package CS_Note.first.swordToOffer.No_21_40;

import java.util.Stack;

public class No30 {
    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
     */
    private Stack<Integer> s = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        s.push(node);
        if (minStack.isEmpty()) {
            minStack.push(node);
        } else {
            if (node > minStack.peek()) {
                minStack.push(minStack.peek());
            } else {
                minStack.push(node);
            }
        }
    }

    public void pop() {
        s.pop();
        minStack.pop();
    }

    public int top() {
        return s.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
