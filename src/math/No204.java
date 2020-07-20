package math;

public class No204 {
    /*
    统计所有小于非负整数 n 的质数的数量。
     */
    public int countPrimes(int n) {
        int[] nums = new int[n + 1]; // 默认都是质数
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] != 1) {// 是合数已经标记
                ans++;
                for (long j = (long) i * i; j < n; j += i) { // i*i会溢出int
                    nums[(int) j] = 1;
                }
            }
        }
        return ans;
    }
}
