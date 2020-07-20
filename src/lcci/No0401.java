package lcci;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No0401 {


    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        if (graph == null || graph.length == 0) {
            return false;
        }
        List<Integer>[] g = buildGraph(n, graph); // 得到邻接表
        Queue<Integer> q = new LinkedList<>();
        q.add(start); // 放入起点
        boolean[] visited = new boolean[n];
        visited[start] = true;

        // 广度优先
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) { // 取出当前所有可以到达的节点
                int tmp = q.poll();
                List<Integer> nextList = g[tmp];
                if (nextList == null)
                    continue;
                for (Integer next : nextList) { // 广度优先
                    if (next == target)
                        return true;
                    if (visited[next])
                        continue;
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
        return false;
    }


    public boolean findWhetherExistsPath_(int n, int[][] graph, int start, int target) {
        // 深度优先 递归
        List<Integer>[] g = buildGraph(n, graph);
        boolean[] visit = new boolean[n];
        return hasPath(g, visit, start, target);
    }

    private boolean hasPath(List<Integer>[] graph, boolean[] visit, int start, int target) {
        if (start == target)
            return true;
        visit[start] = true;
        List<Integer> nextList = graph[start];
        if (nextList == null)
            return false;
        for (Integer next : nextList) {
            if (!visit[next]) {
                if (hasPath(graph, visit, next, target))
                    return true;
            }
        }
        return false;
    }


    private List<Integer>[] buildGraph(int n, int[][] graph) {
        // 构建一个邻接表
        List<Integer>[] list = new ArrayList[n];
        for (int i = 0; i < graph.length; i++) {
            int from = graph[i][0];
            int to = graph[i][1];
            if (list[from] == null) {
                list[from] = new ArrayList<>();
            }
            list[from].add(to);
        }
        return list;
    }
}
