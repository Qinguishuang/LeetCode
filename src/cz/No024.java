package cz;

import linkedlist.ListNode;

/**
 * 24. 两两交换链表中的节点
 */
public class No024 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode f = head;
        ListNode s = head.next;
        while (s != null) {
            f.next = s.next;
            s.next = f;
            pre.next = s;
            pre = f;
            if (f.next != null && f.next.next != null) {
                f = f.next;
                s = f.next;
            } else {
                break;
            }
        }
        return dummyNode.next;
    }

}
