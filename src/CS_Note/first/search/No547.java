package CS_Note.first.search;

public class No547 {
    private int n;

    public int findCircleNum(int[][] M) {
        n = M.length;
        int ans = 0;
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                dfs(M, i, isVisited);
                ans++;
            }
        }
        return ans;
    }

    public void dfs(int[][] M, int i, boolean[] isVisited) {
        isVisited[i] = true;
        for (int j = 0; j < n; j++) {
            if (M[i][j] == 1 && !isVisited[j]) {
                dfs(M, j, isVisited);
            }
        }
    }


}
