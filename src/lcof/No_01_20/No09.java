package lcof.No_01_20;

import java.util.Stack;

public class No09 {

}

class CQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        s1.add(value);
    }

    public int deleteHead() {
        if (s2.size() <= 0) {
            while (s1.size() > 0) {
                s2.add(s1.pop());
            }
        }
        if (s2.size() > 0)
            return s2.pop();
        else
            return -1;
    }
}