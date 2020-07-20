package CS_Note.first.swordToOffer.No_01_20;

public class No10_1 {
    /**
     * 求斐波那契数列的第 n 项，n <= 39。
     * 0, n = 0
     * 1, n = 1
     * f(n-1)+f(n-2), n = 2
     */
    public int Fibonacci(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        int a = 0;
        int b = 1;
        int c = a + b;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public int Fibonacci2(int n) {
        if (n == 0)
            return 0;
        else {
            return Fibonacci2(n - 1) + Fibonacci2(n - 2);
        }
    }
}
