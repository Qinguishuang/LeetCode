package CS_Note.first.swordToOffer.No_01_20;

class TreeLinkNode {

    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null; // 指向父节点

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class No08 {
    /**
     * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        } else {
            while (pNode.next != null) {
                TreeLinkNode tmp = pNode.next;
                if (tmp.left == pNode) {
                    return tmp;
                } else {
                    pNode = pNode.next;
                }
            }
        }
        return null;
    }
}
