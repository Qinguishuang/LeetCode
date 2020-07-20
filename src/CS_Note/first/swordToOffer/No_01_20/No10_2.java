package CS_Note.first.swordToOffer.No_01_20;

public class No10_2 {
    /**
     * 我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。
     * 请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，
     * 总共有多少种方法？
     * 2*1  1
     * 2*2  2
     * 2*n f(n-1)+f(n-2)
     */
    public int RectCover(int n) {
        if (n == 1)
            return 1;
        else if (n == 2)
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
