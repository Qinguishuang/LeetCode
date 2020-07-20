package CS_Note.first.linkedlist;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class No059 {
    public static void main(String[] args) {
        MaxQueue mq = new MaxQueue();
        System.out.println(mq.max_value());
        mq.push_back(1);
        mq.push_back(2);
        System.out.println(mq.max_value());
    }
}

class MaxQueue {
    Queue<Integer> q = new LinkedList<>();
    Deque<Integer> d = new LinkedList<>();

    public MaxQueue() {

    }

    public int max_value() {
        if (q.isEmpty())
            return -1;
        return d.getFirst();
    }

    public void push_back(int value) {
        while (!d.isEmpty() && d.getLast() < value) {
            d.removeLast();
        }
        d.add(value);
        q.add(value);
    }

    public int pop_front() {
        if (q.isEmpty())
            return -1;
        if (q.peek().equals(d.peek())) {
            d.removeFirst();
        }
        return q.remove();
    }
}