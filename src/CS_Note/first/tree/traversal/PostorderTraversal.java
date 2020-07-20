package CS_Note.first.tree.traversal;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return ans;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        ans.add(root.val);
        return ans;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        if (root == null)
            return ans;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                TreeNode tmp = stack.peek();
                if (tmp.right == null || tmp.right == pre) {
                    ans.add(stack.pop().val);
                    pre = tmp;
                } else {
                    root = tmp.right;
                }
            }
        }
        return ans;

    }
}
