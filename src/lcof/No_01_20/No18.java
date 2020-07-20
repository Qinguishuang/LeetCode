package lcof.No_01_20;

import linkedlist.ListNode;

public class No18 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null)
            return null;
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
            } else {
                pre = head;
                head = head.next;
            }
        }
        return dummyNode.next;
    }
}
