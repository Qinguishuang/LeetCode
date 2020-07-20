package lcof.No_41_60;

public class No49 {
    public int nthUglyNumber(int n) {
        if (n <= 0)
            return 0;

        int[] ans = new int[n + 1];
        ans[1] = 1;
        int num2 = 1;
        int num3 = 1;
        int num5 = 1;
        for (int i = 2; i <= n; i++) {
            int next2 = ans[num2] * 2, next3 = ans[num3] * 3, next5 = ans[num5] * 5;
            ans[i] = Math.min(next2, Math.min(next3, next5));
            if (ans[i] == next2)
                num2++;
            if (ans[i] == next3)
                num3++;
            if (ans[i] == next5)
                num5++;
        }
        return ans[n];
    }
}
