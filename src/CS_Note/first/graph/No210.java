package CS_Note.first.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class No210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses]; // 统计入度
        for (int[] p : prerequisites) {
            inDegree[p[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0)
                queue.add(i);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int inDegreeNode = queue.poll();
            ans.add(inDegreeNode); // 将入度为0的节点放入结果集
            for (int[] p : prerequisites) { // 将入度减1
                if (p[1] != inDegreeNode)
                    continue;
                if (inDegree[p[0]] - 1 == 0) { // 减1后入度为0, 加入队列
                    queue.add(p[0]);
                }
                inDegree[p[0]]--;
            }
        }
        if (ans.size() != numCourses)
            return new int[0];
        else {
            return ans.stream().mapToInt(Integer::valueOf).toArray();
        }
    }

    public static void main(String[] args) {
        No210 n = new No210();
        int[][] pre = new int[][]{{2, 1}, {1, 0}};
        System.out.println(Arrays.toString(n.findOrder(3, pre)));
    }
}
