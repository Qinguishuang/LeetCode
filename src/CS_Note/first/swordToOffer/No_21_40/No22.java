package CS_Note.first.swordToOffer.No_21_40;

import linkedlist.ListNode;

public class No22 {
    /**
     * 链表中倒数第 K 个结点
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0)
            return null;
        ListNode tmp = head;
        while (k > 0 && tmp != null) {
            tmp = tmp.next;
            k--;
        }
        if (k > 0)
            return head;
        while (tmp != null) {
            tmp = tmp.next;
            head = head.next;
        }
        return head;
    }
}
