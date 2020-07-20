package CS_Note.first.tree;

import tree.TreeNode;

import java.util.Arrays;

public class No337 {
    /**
     * 2
     * /  \
     * 1      3
     * \
     * 4
     */
    public int rob(TreeNode root) {
        return Arrays.stream(maxRob(root)).max().getAsInt();
    }

    public int[] maxRob(TreeNode root) {
        // ans[0]不包括根节点, ans[1]包括根节点
        int[] ans = new int[2];
        if (root == null) {
            return ans;
        }
        int[] left = maxRob(root.left);
        int[] right = maxRob(root.right);
        // 不包含根节点, 最大值为两个子树的最大值之和
        ans[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 包含根节点, 最大值为两个子树不包含根节点的最大值加上根节点
        ans[1] = left[0] + right[0] + root.val;
        return ans;
    }

}
