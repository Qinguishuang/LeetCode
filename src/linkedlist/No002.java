package linkedlist;

public class No002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode head = dummyNode;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = (x + y + carry) % 10;
            carry = (x + y + carry) / 10;

            head.next = new ListNode(sum);
            head = head.next;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry == 1) {
            head.next = new ListNode(carry);
        }
        return dummyNode.next;
    }
}
