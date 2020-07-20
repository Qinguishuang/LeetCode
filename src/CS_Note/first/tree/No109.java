package CS_Note.first.tree;

import linkedlist.ListNode;
import tree.TreeNode;

public class No109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        return buildTree(head);
    }

    public TreeNode buildTree(ListNode head) {
        if (head == null)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.right = buildTree(slow.next);
        if (pre != null) {
            pre.next = null;
            root.left = buildTree(head);
        } else {
            root.right = null;
        }
        return root;
    }

    public static void main(String[] args) {
        No109 n = new No109();
        ListNode root = new ListNode(-10);
        root.next = new ListNode(-3);
        root.next.next = new ListNode(0);
        root.next.next.next = new ListNode(5);
        root.next.next.next.next = new ListNode(9);
        n.sortedListToBST(root);
    }
}
