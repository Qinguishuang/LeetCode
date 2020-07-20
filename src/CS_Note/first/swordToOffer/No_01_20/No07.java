package CS_Note.first.swordToOffer.No_01_20;

import tree.TreeNode;

public class No07 {
    /**
     * 根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 前序 [1, 2, 4, 7, 3, 5, 6, 8]
     * 中序 [4, 7, 2, 1, 5, 3, 8, 6]
     * <p>
     * [4, 7, 2] 1 [5, 3, 8, 6]
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return buildTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode buildTree(int[] pre, int pre_start, int pre_end, int[] in, int in_start, int in_end) {
        if (pre_start > pre_end || in_start > in_end) {
            return null;
        }
        TreeNode head = new TreeNode(pre[pre_start]);
        int index = 0;// 需要计算出树的两边有多少个元素, 分割前序遍历的数组
        for (int i = in_start; i <= in_end; i++) {
            if (in[i] == pre[pre_start]) {
                index = i;
                break;
            }
        }

        head.left = buildTree(pre, pre_start + 1, pre_start + index, in, in_start, in_start + index - 1);
        head.right = buildTree(pre, pre_start + index + 1, pre_end, in, in_start + index, in_end);
        return head;
    }
}
