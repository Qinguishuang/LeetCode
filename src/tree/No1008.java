package tree;


public class No1008 {
    // 根据先序遍历还原二叉树 [4, 2]
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length <= 0)
            return null;
        else
            return bstFromPreorder(preorder, 0, preorder.length-1);
    }

    // 0 1
    public TreeNode bstFromPreorder(int[] preorder, int start, int end) {
        if (start <= end) {
            TreeNode head = new TreeNode(preorder[start]);

            int mid = start; // 1
            for (int i = start+1; i <= end; i++) {
                if (preorder[i] < preorder[start]) {
                    mid = i;
                } else {
                    break;
                }
            }
            head.left = bstFromPreorder(preorder, start + 1, mid);
            head.right = bstFromPreorder(preorder, mid + 1, end);
            return head;
        } else {
            return null;
        }
    }
}
