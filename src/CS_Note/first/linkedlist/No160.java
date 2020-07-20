package CS_Note.first.linkedlist;

import linkedlist.ListNode;

public class No160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = 0;
        int len2 = 0;
        ListNode tmp = headA;
        while (tmp != null) {
            len1++;
            tmp = tmp.next;
        }
        tmp = headB;
        while (tmp != null) {
            len2++;
            tmp = tmp.next;
        }
        int num = len1 - len2;
        if (num > 0) {
            while (num > 0) {
                headA = headA.next;
                num--;
            }
        } else {
            while (num < 0) {
                headB = headB.next;
                num++;
            }
        }
        while (headA != null) {
            if (headA == headB)
                return headA;
            else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }
}
