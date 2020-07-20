package CS_Note.first.tree;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            double tmpSum = 0;
            int num = q.size(), tmp = q.size();
            while (num > 0) {
                tmpSum += q.peek().val;
                TreeNode node = q.poll();
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                num--;
            }
            ans.add(tmpSum / tmp);
        }
        return ans;
    }
}
