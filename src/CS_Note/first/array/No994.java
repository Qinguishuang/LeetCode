package CS_Note.first.array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 */
public class No994 {

    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = {0, -1, 0, 1};

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int R = grid.length, C = grid[0].length;
        Queue<Integer> queue = new LinkedList<>(); // 多个起点的广度优先，将起点放入队列
        Map<Integer, Integer> minutes = new HashMap<>(); // 记录每一个位置的腐烂时间
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 2) {
                    int position = i * C + j;
                    queue.add(position);
                    minutes.put(position, 0);
                }
            }
        }
        int ans = 0; // 记录最长的那个时间
        while (!queue.isEmpty()) {
            int position = queue.poll();
            int r = position / C, c = position % C; // 还原出原来的位置
            for (int i = 0; i < 4; i++) { // 感染四个方向
                int nr = r + dr[i];
                int nc = c + dc[i]; // 计算四周的新坐标
                if (nr >= 0 &&
                        nr < R &&
                        nc >= 0 &&
                        nc < C &&
                        grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    int newPos = nr * C + nc;
                    queue.add(newPos); // 新腐烂的放入队列
                    minutes.put(newPos, minutes.get(position) + 1); // 记录腐烂的时间
                    ans = minutes.get(newPos);
                }
            }
        }
        // 看看是否还有新鲜的
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }
        return ans;
    }
}
