package CS_Note.first.swordToOffer.No_41_60;

import linkedlist.ListNode;

public class No52 {
    /**
     * 两个链表的第一个公共结点
     *
     * 第一个链表 a+c
     * 第二个链表 b+c
     * a+c + b == b+c + a
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null)
            return null;
        ListNode l1 = pHead1;
        ListNode l2 = pHead2;
        while (l1 != l2) {
            l1 = (l1 == null? pHead2: l1.next);
            l2 = (l2 == null? pHead1: l2.next);
        }
        return l1;
    }
}
