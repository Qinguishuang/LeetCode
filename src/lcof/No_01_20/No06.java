package lcof.No_01_20;

import linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

public class No06 {
    List<Integer> tmp = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        recur(head);
        int[] ans = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            ans[i] = tmp.get(i);
        }
        return ans;
    }

    private void recur(ListNode head) {
        if (head == null)
            return;
        recur(head.next);
        tmp.add(head.val);
    }
}
