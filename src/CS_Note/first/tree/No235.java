package CS_Note.first.tree;

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

    public TreeNode dfs(TreeNode root, int p, int q) {
        if (root.val <= p && root.val >= q) {
            return root;
        } else if (root.val >= p) {
            return dfs(root.left, p, q);
        } else {
            return dfs(root.right, p, q);
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor2(root.left, p, q);
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor2(root, p, q);
        return root;
    }
}
