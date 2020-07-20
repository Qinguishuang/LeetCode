package CS_Note.first.linkedlist;


import linkedlist.ListNode;

import java.util.Stack;

public class No445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.add(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode dummyNode = new ListNode(0);
        while (!s1.isEmpty() && !s2.isEmpty()) {
            int sum = s1.pop() + s2.pop() + carry;
            carry = sum / 10;
            ListNode tmp = new ListNode(sum % 10);
            tmp.next = dummyNode.next;
            dummyNode.next = tmp;
        }
        while (!s1.isEmpty()) {
            int sum = carry + s1.pop();
            carry = sum / 10;
            ListNode tmp = new ListNode(sum % 10);
            tmp.next = dummyNode.next;
            dummyNode.next = tmp;
        }
        while (!s2.isEmpty()) {
            int sum = carry + s2.pop();
            carry = sum / 10;
            ListNode tmp = new ListNode(sum % 10);
            tmp.next = dummyNode.next;
            dummyNode.next = tmp;
        }
        if (carry != 0) {
            ListNode tmp = new ListNode(carry);
            tmp.next = dummyNode.next;
            dummyNode.next = tmp;
        }
        return dummyNode.next;
    }


    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.add(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode dummyNode = new ListNode(0);
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int a = 0, b = 0;
            if (!s1.isEmpty()) {
                a = s1.pop();
            }
            if (!s2.isEmpty()) {
                b = s2.pop();
            }
            int sum = a + b + carry;
            carry = sum / 10;
            ListNode tmp = new ListNode(sum % 10);
            tmp.next = dummyNode.next;
            dummyNode.next = tmp;
        }
        return dummyNode.next;
    }
}
