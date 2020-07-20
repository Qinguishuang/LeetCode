package CS_Note.first.bit;

public class No338 {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            // result[i] = result[i >> 1] + (i & 1);
            ans[i] = ans[i / 2];
            if (i % 2 != 0)
                ans[i]++;
        }
        return ans;
    }
}
