package cz;

import linkedlist.ListNode;

public class No025 {
    /**
     * k = 3
     * dummy -> 1 -> 2 -> 3 -> 4 -> 4
     * pre  start      end next
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        ListNode end = dummyNode;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null)
                break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummyNode.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    private ListNode reverse2(ListNode head) {
        if (head == null)
            return null;
        ListNode tmp = reverse2(head.next);
        head.next.next = head;
        head.next = null;
        return tmp;
    }
}
