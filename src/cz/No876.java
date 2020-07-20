package cz;

import linkedlist.ListNode;

public class No876 {
    public ListNode middleNode(ListNode head) {
        if (head == null)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        } // 1 2 3 4
        return slow;
    }
}
