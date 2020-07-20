package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Traversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return null;
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        while (root != null || !s.isEmpty()) {
            if (root != null) {
                s.push(root);
                ans.add(root.val);
                root = root.left;
            } else {
                root = s.pop().right;
            }
        }
        return ans;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return null;

        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        while (root != null || !s.isEmpty()) {
            if (root != null) {
                s.push(root);
                root = root.left;
            } else {
                ans.add(s.peek().val);
                root = s.pop().right;
            }
        }
        return ans;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return null;
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode pre = null;
        while (root != null || !s.isEmpty()) {
            if (root != null) {
                s.push(root);
                root = root.left;
            } else {
                TreeNode tmp = s.peek();
                if (tmp.right == null || tmp.right == pre) { // 右边已经遍历过
                    ans.add(s.pop().val);
                    pre = tmp;
                } else {
                    root = tmp.right;
                }
            }
        }
        return ans;
    }


}
