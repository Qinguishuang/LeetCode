package lcof.No_21_40;

import tree.TreeNode;

public class No26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null) // 空树不是任意一个树的子结构
            return false;
        if (A.val == B.val)
            return isSub(A, B);
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean isSub(TreeNode a, TreeNode b) {
        if (b == null)
            return true;
        if (a == null)
            return false;
        if (a.val == b.val) {
            return isSub(a.left, b.left) && isSub(a.right, b.right);
        } else {
            return false;
        }
    }
}
