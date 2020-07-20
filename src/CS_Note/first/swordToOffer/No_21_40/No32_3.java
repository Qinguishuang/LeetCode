package CS_Note.first.swordToOffer.No_21_40;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class No32_3 {
    /**
     * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
     * 第三行按照从左到右的顺序打印，其他行以此类推。
     */
    public ArrayList<ArrayList<Integer>> PrintFromTopToBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (levelNum > 0) {
                TreeNode tmp = queue.poll();
                list.add(tmp.val);

                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
                levelNum--;
            }
            if (reverse)
                Collections.reverse(list);
            reverse = !reverse;
            ans.add(list);
        }
        return ans;
    }
}