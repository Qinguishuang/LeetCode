package CS_Note.first.swordToOffer.No_01_20;

public class No10_3 {
    /**
     * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。
     * 求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     */
    public int JumpFloor(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int a = 1;
        int b = 2;
        int c = a + b;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
