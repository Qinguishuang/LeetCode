package CS_Note.first.swordToOffer.No_21_40;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class No32_2 {
    /**
     * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
     */
    public ArrayList<ArrayList<Integer>> PrintFromTopToBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
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
            ans.add(list);
        }
        return ans;
    }
}