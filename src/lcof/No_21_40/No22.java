package lcof.No_21_40;

import linkedlist.ListNode;

public class No22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k <= 0)
            return head;
        ListNode tmp = head;
        for (int i = 0; i < k+1; i++) {
            tmp = tmp.next;
        }
        if (tmp == null) {
            return head;
        }
        while (tmp != null || tmp.next != null) {
            tmp = tmp.next;
            head = head.next;
        }
        return head.next;
    }
}
