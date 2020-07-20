package CS_Note.first.swordToOffer.No_21_40;

import tree.TreeNode;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class No36 {

    private TreeNode pre = null;
    private TreeNode head = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        inorderTraversal(pRootOfTree);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void inorderTraversal(TreeNode root) {
        if (root == null)
            return;

        inorderTraversal(root.left);

        root.left = pre;
        if (pre != null)
            pre.right = root;
        pre = root;
        if (head == null) // 记录头结点
            head = root;

        inorderTraversal(root.right);
    }

}
