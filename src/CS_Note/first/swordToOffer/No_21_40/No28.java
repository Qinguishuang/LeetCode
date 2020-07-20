package CS_Note.first.swordToOffer.No_21_40;

import tree.TreeNode;

public class No28 {
    /**
     * 请实现一个函数，用来判断一颗二叉树是不是对称的。
     * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
     */
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null)
            return true;
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    boolean isSymmetrical(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return  true;
        if (node1 == null || node2 == null)
            return false;

        if (node1.val == node2.val) {
            return isSymmetrical(node1.left, node2.right) &&
                    isSymmetrical(node1.right, node2.left);
        } else {
            return false;
        }
    }

}
