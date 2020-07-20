package CS_Note.first.tree;

import tree.TreeNode;

public class No572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        if (s.val == t.val) // 头结点相等, 特殊处理
            return isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        if (s.val == t.val)
            return isSame(s.left, t.left) && isSame(s.right, t.right);
        return false;
    }

}
