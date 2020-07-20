package CS_Note.second.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size(), size_2 = size;
            double sum = 0D;
            while (size-- > 0) {
                TreeNode tmp = q.poll();
                sum += tmp.val;
                if (tmp.left != null)
                    q.add(tmp.left);
                if (tmp.right != null) {
                    q.add(tmp.right);
                }
            }
            ans.add(sum / size_2);
        }
        return ans;
    }
}
