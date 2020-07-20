package linkedlist;

public class No019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre = head;
        ListNode tail = head;
        while (n > 0) {
            pre = pre.next;
            n--;
        }
        while (pre.next != null) {
            pre = pre.next;
            tail = tail.next;
        }
        tail = tail.next.next;
        return dummyNode.next;
    }
}
