package CS_Note.first.tree;

import tree.TreeNode;

import java.util.Stack;

public class No617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        TreeNode root = new TreeNode(t1.val + t2.val);
        if (t1.left != null && t2.left != null)
            root.left = mergeTrees(t1.left, t2.left);
        else if (t1.left != null)
            root.left = t1.left;
        else
            root.left = t2.left;
        if (t1.right != null && t2.right != null)
            root.right = mergeTrees(t1.right, t2.right);
        else if (t1.right != null)
            root.right = t1.right;
        else
            root.right = t2.right;
        return root;
    }

    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{t1, t2});
        while (!stack.isEmpty()) {
            TreeNode[] tmp = stack.pop();
            if (tmp[0] == null || tmp[1] == null) {
                continue;
            }
            tmp[0].val += tmp[1].val;
            if (tmp[0].left == null) {
                tmp[0].left = tmp[1].left;
            } else {
                stack.push(new TreeNode[]{tmp[0].left, tmp[1].left});
            }
            if (tmp[0].right == null) {
                tmp[0].right = tmp[1].right;
            } else {
                stack.push(new TreeNode[]{tmp[0].right, tmp[1].right});
            }
        }
        return t1;
    }
}
