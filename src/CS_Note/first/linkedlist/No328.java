package CS_Note.first.linkedlist;

import linkedlist.ListNode;

public class No328 {
    /**
     * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
     * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode j = head;
        ListNode o = head.next;
        ListNode oHead = o;
        while (o.next != null && o.next.next != null) {
            j.next = o.next;
            o.next = o.next.next;

            j = j.next;
            o = o.next;
        }
        if (o.next != null) {
            j.next = o.next;
            j = j.next;
        }
        o.next = null;
        j.next = oHead;
        return head;
    }

    public static void main(String[] args) {
        No328 n = new No328();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        n.oddEvenList(head);
    }
}
