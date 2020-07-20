package CS_Note.first.swordToOffer.No_01_20;

import linkedlist.ListNode;

public class No18_2 {
    /**
     * 删除链表中重复的结点，重复的结点不保留，返回链表头指针
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;

        ListNode root = new ListNode(-1);
        root.next = pHead;

        ListNode curr = pHead;
        ListNode pre = root;

        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                pre.next = curr.next;
            } else {
                pre = curr;
            }
            curr = curr.next;
        }
        return root.next;

    }
}
