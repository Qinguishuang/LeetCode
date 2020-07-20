package CS_Note.first.swordToOffer.No_01_20;

import linkedlist.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class No06 {
    /**
     * 从尾到头反过来打印出每个结点的值。
     * 递归(recursive)
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (listNode != null) {
            ans.addAll(printListFromTailToHead(listNode.next));
            ans.add(listNode.val);
        }
        return ans;
    }

    /**
     * 头插法
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ListNode head = new ListNode(0);
        while (listNode != null) {
            ListNode tmp = listNode.next;
            ListNode second = head.next;
            head.next = listNode;
            listNode = tmp;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        head = head.next;
        while (head != null) {
            ans.add(head.val);
            head = head.next;
        }
        return ans;
    }

    /**
     * 使用栈
     */
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.add(listNode.val);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }
        return ans;
    }
}
