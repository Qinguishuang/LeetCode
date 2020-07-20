package CS_Note.first.dp;

public class No343 {
    /**

     */
    public int integerBreak(int n) {
        if (n <= 3)
            return n - 1;
        if (n % 3 == 1) {
            return (int) (Math.pow(3, n / 3 - 1) * 4);
        } else if (n % 3 == 0) {
            return (int) Math.pow(3, n / 3);
        } else {
            return (int) (Math.pow(3, n / 3) * 2);
        }
    }
}
