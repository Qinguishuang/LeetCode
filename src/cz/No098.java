package cz;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No098 {
    /**
     * 中序遍历
     */
    public boolean isValidBST(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();

        while (root != null || !s.isEmpty()) {
            if (root != null) {
                s.add(root);
                root = root.left;
            } else {
                TreeNode tmp = s.pop();
                ans.add(tmp.val);
                root = tmp.right;
            }
        }
        for (int i = 1; i < ans.size(); i++) {
            if (ans.get(i) < ans.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> postOrder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode pre = null;
        while (root != null || !s.isEmpty()) {
            if (root != null) {
                s.add(root);
                root = root.left;
            } else {
                TreeNode tmp = s.peek();
                if (tmp.right == null || tmp.right == pre) {
                    ans.add(s.pop().val);
                    pre = tmp;
                } else {
                    root = tmp.right;
                }
            }
        }

        return ans;


    }

    public static void main(String[] args) {

    }
}
