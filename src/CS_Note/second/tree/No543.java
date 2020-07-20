package CS_Note.second.tree;

public class No543 {
    private int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getDepth(root);
        return ans ;
    }

    private int getDepth(TreeNode root) {
        if (root == null)
            return 0;
        int l = getDepth(root.left);
        int r = getDepth(root.right);
        ans = Math.max(ans, l + r );
        return Math.max(l, r) + 1;
    }


}
