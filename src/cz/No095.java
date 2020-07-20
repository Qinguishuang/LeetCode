package cz;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class No095 {
    List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> generateTrees(int n) {
        if (n <= 0)
            return null;
        generateTrees(1, n);
        return ans;
    }

    public List<TreeNode> generateTrees(int l, int r) {
        List<TreeNode> tmp = new ArrayList<>();
        if (l > r) {
            tmp.add(null);
            return tmp;
        }
        for (int i = l; i <= r; i++) {
            TreeNode head = new TreeNode(i);
            List<TreeNode> left = generateTrees(l, i - 1);
            List<TreeNode> right = generateTrees(i + 1, r);
            for (int j = 0; j < left.size(); j++) {
                for (int k = 0; k < right.size(); k++) {
                    head.left = left.get(j);
                    head.right = right.get(k);
                    ans.add(head);
                }
            }
        }
        return tmp;
    }
}
