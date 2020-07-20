package CS_Note.first.tree;

import tree.TreeNode;

import java.util.ArrayList;

public class No653 {
    ArrayList<Integer> list = new ArrayList<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;
        dfs(root);
        int l = 0;
        int h = list.size() - 1;
        while (l < h) {
            if (list.get(l) + list.get(h) == k)
                return true;
            else if (list.get(l) + list.get(h) > k) {
                h--;
            } else {
                l++;
            }
        }
        return false;
    }

    public void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
