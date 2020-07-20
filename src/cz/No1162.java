package cz;

import java.util.LinkedList;
import java.util.Queue;

public class No1162 {
    // 海洋区域到与它最近的陆地区域的距离是最大的
    public int maxDistance(int[][] grid) {
        if (grid == null || grid.length == 0)
            return -1;
        int[] x = {0, 0, 1, -1};
        int[] y = {1, -1, 0, 0};
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    q.add(new int[]{i, j});
                }
            }
        }
        boolean hasOcean = false;
        int[] point = null;
        while (!q.isEmpty()) {
            point = q.poll();
            for (int i = 0; i < 4; i++) {
                int newX = point[0] + x[i];
                int newY = point[1] + y[i];
                if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length || grid[newX][newY] != 0) {
                    continue;
                }
                grid[newX][newY] = grid[point[0]][point[1]] + 1;
                hasOcean = true;
                q.offer(new int[]{newX, newY});
            }
        }
        if (point == null || !hasOcean) {
            return -1;
        }
        return grid[point[0]][point[1]] - 1;
    }
}
