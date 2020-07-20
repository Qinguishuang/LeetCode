package lcof.No_21_40;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No32_1 {
    public int[] levelOrder(TreeNode root) {
        if (root == null)
            return new int[0];
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        q.add(root);
        int num = 1;
        while (!q.isEmpty()) {
            num = q.size();
            for (int i = 0; i < num; i++) {
                TreeNode tmp = q.remove();
                list.add(tmp.val);
                if (tmp.left != null)
                    q.add(tmp.left);
                if (tmp.right != null)
                    q.add(tmp.right);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
