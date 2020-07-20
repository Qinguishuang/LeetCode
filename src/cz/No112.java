package cz;

import tree.TreeNode;

import java.util.Stack;

public class No112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sums = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.add(root);

                if (sums.isEmpty()) {
                    sums.add(root.val);
                } else {
                    sums.add(sums.peek() + root.val);
                }
                if (root.left == null && root.right == null && sums.peek() == sum) {
                    return true;
                }
                root = root.left;
            } else {
                root = stack.pop().right;
                sums.pop();
            }
        }
        return false;
    }


}
