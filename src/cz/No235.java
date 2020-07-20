package cz;

import tree.TreeNode;

public class No235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (p.val >= q.val)
            return dfs(root, p.val, q.val);
        else 
            return dfs(root, q.val, p.val);
    }

    private TreeNode dfs(TreeNode root, int p, int q) {
        if (root.val <= p && root.val >= q)
            return root;
        if (root.val > p)
            return dfs(root.left, p, q);
        return dfs(root.right, p, q);
    }
}
