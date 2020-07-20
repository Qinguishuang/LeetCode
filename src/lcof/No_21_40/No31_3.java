package lcof.No_21_40;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class No31_3 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);
        int flag = 0; // 0 正向 1 反向
        while (!q.isEmpty()) {
            int num = q.size();
            for (int i = 0; i < num; i++) {
                TreeNode tmp = q.pollFirst();
                list.add(tmp.val);
                if (tmp.left != null)
                    q.add(tmp.left);
                if (tmp.right != null)
                    q.add(tmp.right);
            }
            if (flag == 0) {
                ans.add(new ArrayList<>(list));
                flag = 1;
            } else {
                Collections.reverse(list);
                ans.add(new ArrayList<>(list));
                flag = 0;
            }
            list.clear();
        }
        return ans;
    }
}
