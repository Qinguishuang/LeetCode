package lcof.No_01_20;

import tree.TreeNode;

public class No07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] pre, int preS, int preE, int[] in, int inS, int inE) {
        if (preS > preE || inS > inE) {
            return null;
        }
        int num = 0;
        TreeNode root = new TreeNode(pre[preS]);
        for (int i = inS; i <= inE; i++) {
            if (in[i] == pre[preS]) {
                num = i;
                break;
            }
        }
        // * 前序 [1, 2, 4, 7, 3, 5, 6, 8]
        // * 中序 [4, 7, 2, 1, 5, 3, 8, 6]
        // * buildTree(pre, 0, 7, in, 0, 7) index=3
        // root.left = buildTree(pre, 0, , in, inS, inS)
        // * [4, 7, 2] 1 [5, 3, 8, 6]
        // 左边节点个数 num-inS
        root.left = buildTree(pre, preS + 1, preS + num - inS, in, inS, inS + num - inS - 1);
        root.right = buildTree(pre, preS+num-inS+1, preE, in, num+1, inE);
        return root;
    }

    public static void main(String[] args) {
        No07 n = new No07();
        int[] pre = {3, 9, 20, 15, 7};
        int[] in = {9, 3, 15, 20, 7};
        n.buildTree(pre, in);
    }
}
