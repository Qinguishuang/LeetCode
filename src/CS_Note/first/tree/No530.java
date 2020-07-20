package CS_Note.first.tree;

import tree.TreeNode;

import java.util.Stack;

public class No530 {
    private int ans = Integer.MAX_VALUE;
    private TreeNode preNode = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null)
            return -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.left);
        if (preNode != null)
            ans = Math.max(ans, Math.abs(preNode.val - root.val));
        preNode = root;
        dfs(root.right);
    }

    public int getMinimumDifference2(TreeNode root) {
        if (root == null)
            return -1;
        Stack<TreeNode> s = new Stack<>();
        int ans = Integer.MAX_VALUE;
        while (!s.isEmpty() || root != null) {
            if (root != null) {
                s.add(root);
                root = root.left;
            } else {
                TreeNode node = s.pop();
                if (preNode != null)
                    ans = Math.min(ans, Math.abs(node.val - preNode.val));
                preNode = node;
                root = node.right;
            }
        }
        return ans;
    }
}
