package CS_Note.first.doublepointer;

import linkedlist.ListNode;

public class No142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                slow = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
