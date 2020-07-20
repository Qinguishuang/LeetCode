package linkedlist;

public class No061 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k <= 0)
            return head;
        ListNode ans = null;
        ListNode tmp = head;
        int len = 0;
        while (head != null) {
            head = head.next;
            len ++;
        }
        k = len - k % len;
        head = tmp;

        while (--k > 0) {
            head = head.next;
        }
        ans = head;
        head.next = null;
        head = ans;
        while (head.next != null) {
            head = head.next;
        }
        head.next = tmp;
        return ans;
    }


}
