package CS_Note.first.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class No435 {

    public static void main(String[] args) {
        int[][] a = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        eraseOverlapIntervals(a);
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0)
            return 0;
        // 按照第一个值排序
        // Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int count = 0, last = intervals[0][1];// 记录上一个的末尾
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= last) { // 比较上一个的末尾 和 这个的首位
                last = intervals[i][1];
            } else {
                last = Math.min(last, intervals[i][1]);
                count++;
            }
        }
        return count;
    }
}
