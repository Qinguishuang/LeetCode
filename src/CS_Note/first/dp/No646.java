package CS_Note.first.dp;

import java.util.Arrays;
import java.util.Comparator;

public class No646 {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs[0].length == 0)
            return 0;
        int ans = 1;
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        System.out.println(Arrays.deepToString(pairs));
        int end = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > end) {
                ans++;
                end = pairs[i][1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        No646 n = new No646();
        int[][] pairs = {{-10, -8}, {8, 9}, {-5, 0}, {6, 10}, {-6, -4}, {1, 7}, {9, 10}, {-4, 7}};
        System.out.println(n.findLongestChain(pairs));
    }
}
