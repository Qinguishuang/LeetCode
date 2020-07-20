package divide_conquer;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class No095 {
    /**
     * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
     */
    public List<TreeNode> generateTrees(int n) {
        if (n < 1)
            return new ArrayList<TreeNode>();
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int l, int r) {
        List<TreeNode> ans = new ArrayList<>();
        if (l > r) {
            ans.add(null);
            return ans;
        }

        for (int i = l; i <= r; i++) {

            List<TreeNode> left = generateTrees(l, i - 1);
            List<TreeNode> right = generateTrees(i + 1, r);

            for (TreeNode lnode : left) {
                for (TreeNode rnode : right) {
                    TreeNode head = new TreeNode(i);
                    head.left = lnode;
                    head.right = rnode;
                    ans.add(head);
                }
            }
        }
        return ans;
    }
}
