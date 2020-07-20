package lcof.No_41_60;

import linkedlist.ListNode;

public class No52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null? headB: a.next;
            b = b == null? headA: b.next;
        }
        return a;
    }
}
