package CS_Note.first.search;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class No257 {
    /**
     * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
     */
    private List<ArrayList<Integer>> ans = new ArrayList<>();

    public List<ArrayList<Integer>> binaryTreePaths(TreeNode root) {
        if (root == null)
            return ans;
        ArrayList<Integer> tmp = new ArrayList<>();
        backtracking(root, tmp);
        return ans;
    }

    public void backtracking(TreeNode root, ArrayList<Integer> value) {
        if (root == null)
            return;
        value.add(root.val);
        if (root.left == null && root.right == null) {
            ans.add(value);
        } else {
            backtracking(root.left, value);
            backtracking(root.right, value);
        }
        value.remove(value.size() - 1);
    }
}
