package CS_Note.first.tree.traversal;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return ans;
        ans.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return ans;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null)
            return ans;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                ans.add(root.val);
                stack.add(root);
                root = root.left;
            } else {
                root = stack.pop().right;
            }
        }
        return ans;
    }
}
