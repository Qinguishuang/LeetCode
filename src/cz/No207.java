package cz;

import java.util.LinkedList;
import java.util.Queue;

public class No207 {
    // 拓扑排序 [[0, 1]] // 向学习0先学习1   1 -> 0
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        for (int[] p : prerequisites) { // 统计入度
            inDegrees[p[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>(); // 存放可以学习的课程
        for (int i = 0; i < numCourses; i++) { // 统计入度为0的课程，直接可以学习
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int pre = queue.poll(); // 依次出队，将入度减1
            numCourses--;
            for (int[] p : prerequisites) {
                if (p[1] != pre) { // [0, 1]  1 -> 0
                    continue;
                }
                if (inDegrees[p[0]] - 1 == 0) {
                    queue.add(p[0]);
                }
                inDegrees[p[0]]--;
            }
        }
        return numCourses == 0;
    }

    public static void main(String[] args) {
        No207 n = new No207();
        int[][] p = {{1, 0}, {1, 2}, {0, 1}};
        System.out.println(n.canFinish(3, p));
    }
}
