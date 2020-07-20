package CS_Note.first.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class No452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0)
            return 0;
        // Arrays.sort(points, (a, b) -> (a[1] - b[1]));
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int count = 0;
        int axis = points[0][1]; // 记录上一个的末尾
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > axis) {
                count++;
                axis = points[i][1];
            }
        }
        return count;
    }
}
