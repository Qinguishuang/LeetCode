package CS_Note.first.search;


public class No01 {
    /**
     * 计算在网格中从原点到特定点的最短路径长度
     * [1,1,0,1]
     * [1,0,1,0]
     * [1,1,1,1]queue.add(new Pair<>(nr, nc));
     * [1,0,1,1]
     */
    // public int minPathLength(int[][] grids, int tr, int tc) {
    //
    //     final int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    //     final int m = grids.length, n = grids[0].length;
    //     Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
    //     queue.add(new Pair<>(0, 0));
    //     int pathLen = 0;
    //     while (!queue.isEmpty()) {
    //         int size = queue.size();
    //         pathLen++;
    //         while (size-- > 0) {
    //             Pair<Integer, Integer> curr = queue.poll();
    //             int cr = curr.getKey(), cc = curr.getValue();
    //             grids[cr][cc] = 0;
    //             for (int[] d : direction) {
    //                 int nr = cr + d[0], nc = cc + d[1];
    //                 if (nr < 0 || nr >= m || nc < 0 || nc > m || grids[nr][nc] == 0) {
    //                     continue;
    //                 }
    //                 if (nr == tr && nc == tc)
    //                     return pathLen;
    //                 queue.add(new Pair<>(nr, nc));
    //             }
    //         }
    //     }
    //     return -1;
    //
    // }
}
