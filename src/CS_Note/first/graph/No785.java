package CS_Note.first.graph;

public class No785 {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0)
            return false;

        int[] colors = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!dfs(graph, i, colors, 0))
                return false;
        }
        return true;
    }

    public boolean dfs(int[][] graph, int i, int[] colors, int lastColor) {
        // 0未染色, 1黑, 2白
        if (colors[i] != 0)
            return colors[i] != lastColor;
        colors[i] = (lastColor == 1 ? 2 : 1);
        for (int j = 0; j < graph[i].length; j++) {
            if (!dfs(graph, graph[i][j], colors, colors[i]))
                return false;
        }
        return true;
    }
}
