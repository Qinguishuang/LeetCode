package cz;

public class No785 {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0)
            return false;
        int[] color = new int[graph.length];
        for (int i = 0; i < graph.length; i++) { // 防止是非连通图
            if (!dfs(graph, i, color, 0)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int i, int[] color, int lastColor) {
        // 0未染色 1黑 2白
        if (color[i] != 0) { // 已经染过色了
            return color[i] != lastColor; // 必须和上一个不同
        }
        color[i] = (lastColor == 1 ? 2 : 1);// 涂成相反的颜色
        for (int j = 0; j < graph[i].length; j++) { // 深度优先
            if (!dfs(graph, graph[i][j], color, color[i]))
                return false;
        }
        return true;
    }
}
