package lcof.No_01_20;

import java.math.BigInteger;

public class No14 {
    public int cuttingRope(int n) {
        if (n == 2)
            return 1;
        BigInteger[] ans = new BigInteger[n + 1];
        ans[1] = BigInteger.valueOf(0);
        ans[2] = BigInteger.valueOf(1); // 1 * 1
        for (int i = 3; i <= n; i++) { // 长度
            ans[i] = new BigInteger("0");
            for (int j = 1; j < i; j++) { // 分割长度
                ans[i] = ans[i].max(BigInteger.valueOf(j).multiply(ans[i - j]));
                ans[i] = ans[i].max(BigInteger.valueOf((i - j) * j));
            }
        }
        return ans[n].mod(new BigInteger("1000000007")).intValue();
    }

    public static void main(String[] args) {
        No14 n = new No14();
        System.out.println(n.cuttingRope(15));
    }
}
