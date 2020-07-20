package CS_Note.first.swordToOffer.No_01_20;

import linkedlist.ListNode;

public class No18_1 {
    /**
     *在 O(1) 时间内删除链表节点
     */
    public ListNode deleteNode(ListNode head, ListNode tobeDelete) {
        if (head == null)
            return null;
        if (tobeDelete.next == null) { // 判断是否只有一个节点
            if (head == tobeDelete)
                head = null;
            else {
                ListNode tmp = head;
                while (tmp.next != tobeDelete) {
                    tmp = tmp.next;
                }
                tmp.next = null;
            }
        } else {
            tobeDelete.val = tobeDelete.next.val;
            tobeDelete.next = tobeDelete.next.next;
        }
        return head;
    }
}
