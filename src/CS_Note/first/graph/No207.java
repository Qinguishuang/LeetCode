package CS_Note.first.graph;

import java.util.LinkedList;
import java.util.Queue;

public class No207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0)
            return true;
        int[] inDegrees = new int[numCourses];
        for (int[] p : prerequisites) { // 统计每个节点的入度
            inDegrees[p[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) { // 将入度为0的节点放入队列(安全的节点)
            if (inDegrees[i] == 0)
                queue.add(i);
        }
        //当 queue 非空时，依次将队首节点出队，在课程安排图中删除此节点 pre(入度减1)
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for (int[] p : prerequisites) {
                if (p[1] != pre)
                    continue;
                // 当入度 -1后邻接节点 cur 的入度为 00，说明 cur 所有的前驱节点已经被 “删除”
                if (inDegrees[p[0]] - 1 == 0) { // (入度为0说明没有前驱节点, 安全)
                    queue.add(p[0]);
                }
                inDegrees[p[0]]--;
            }
        }
        // 若不构成有向无环图, 所有的节点都会入队出队
        // 否则, 一定有节点入度不为0
        return numCourses == 0;
    }

    /**
     * 深度优先遍历 判断本次遍历是否存在环
     */
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        int[][] adjacency = new int[numCourses][numCourses]; // 邻接表
        // 借助一个标志列表 flags，用于判断每个节点 i （课程）的状态：
        // 未被 DFS 访问：i == 0；
        // 已被其他节点启动的DFS访问：i == -1；
        // 已被当前节点启动的DFS访问：i == 1。对 numCourses 个节点依次执行 DFS，判
        int[] flag = new int[numCourses];
        for (int[] p : prerequisites) { // 创建邻接表
            adjacency[p[1]][p[0]] = 1;
        }
        // 对 numCourses 个节点依次执行 DFS，判断每个节点起步 DFS 是否存在环，若存在环直接返回 FalseFalse
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjacency, flag, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int[][] adjacency, int[] flags, int i) {
        if (flags[i] == 1) { // 存在环
            return false;
        }
        if (flags[i] == -1) { // 被其他节点访问过
            return true;
        }
        flags[i] = 1; // 当前节点正在访问
        for (int j = 0; j < adjacency.length; j++) { //访问当前节点的邻接节点
            if (adjacency[i][j] == 1 && !dfs(adjacency, flags, j)) // 发现环返回false
                return false;
        }
        flags[i] = -1; // 访问完没有发现环, 置为-1
        return false;
    }
}
