package CS_Note.first.linkedlist;

import linkedlist.ListNode;

public class No234 {
    /**
     * 请判断一个链表是否为回文链表。
     */
    public boolean isPalindrome(ListNode head) {
        int num = 0;
        ListNode root = head;
        while (root != null) {
            num++;
            root = root.next;
        }
        if (num % 2 == 0) {
            num = num / 2;
        } else {
            num = num / 2 + 1;
        }
        // 翻转后半段
        root = head;
        while (num > 0) {
            num--;
            root = root.next;
        }
        ListNode tail = reverse(root);
        return isSame(head, tail);

    }

    public ListNode reverse(ListNode root) {
        ListNode pre = null;
        while (root != null) {
            ListNode next = root.next;
            root.next = pre;
            pre = root;
            root = next;
        }
        return pre;
    }

    public boolean isSame(ListNode head, ListNode tail) {
        while (head != null && tail != null) {
            if (head.val != tail.val) {
                return false;
            }
            head = head.next;
            tail = tail.next;
        }
        return true;
    }
}
