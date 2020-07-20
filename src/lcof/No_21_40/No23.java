package lcof.No_21_40;

import linkedlist.ListNode;

public class No23 {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
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
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = reverseList2(head.next);
        head.next.next = p;
        head.next = null;
        return p;
    }
}
