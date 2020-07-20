package CS_Note.first.tree;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class No513 {

    public int findBottomLeftValue(TreeNode root) {
        List<TreeNode> list = new ArrayList();
        list.add(root);
        TreeNode node = root;
        for (int i = 0; i < list.size(); i++) {
            node = list.get(i);
            if (node.right != null)
                list.add(node.right);
            if (node.left != null)
                list.add(node.left);
        }
        return node.val;
    }

    public static void main(String[] args) {
        No513 n = new No513();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(n.findBottomLeftValue(root));
    }
}
