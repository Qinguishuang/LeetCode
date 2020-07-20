package CS_Note.first.swordToOffer.No_21_40;

import tree.TreeNode;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class No34 {
    private ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null)
            return ans;
        FindPath(root, target, new ArrayList<Integer>());
        return ans;
    }

    public void FindPath(TreeNode root, int target, ArrayList<Integer> path) {
        if (root == null)
            return;
        path.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null)
            ans.add(new ArrayList<>(path));
        else {
            FindPath(root.left, target, path);
            FindPath(root.right, target, path);
        }
        path.remove(path.size() - 1);
    }
}
