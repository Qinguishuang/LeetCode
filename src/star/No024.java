package star;

import linkedlist.ListNode;

public class No024 {
    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        ListNode last = head.next;

        while (last != null) {
            pre.next = last;
            head.next = last.next;
            last.next = head;

            pre = head;
            if (pre.next != null) {
                head = pre.next;
                last = head.next;
            } else {
                break;
            }
        }
        return dummyNode.next;
    }

}
