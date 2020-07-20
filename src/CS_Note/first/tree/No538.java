package CS_Note.first.tree;

import tree.TreeNode;

import java.util.Stack;

public class No538 {
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return null;
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }

    public TreeNode convertBST2(TreeNode root) {
        if (root == null)
            return null;
        Stack<TreeNode> s = new Stack<>();
        TreeNode dummyNode = root;
        while (!s.isEmpty() || root != null) {
            if (root != null) {
                s.add(root);
                root = root.right;
            } else {
                TreeNode node = s.pop();
                sum += node.val;
                node.val = sum;
                root = node.left;
            }
        }
        return dummyNode;
    }
}
