package CS_Note.first.swordToOffer.No_01_20;

public class No16 {

    public static void main(String[] args) {
        System.out.println(Power(2, -3));
    }

    /**
     * 给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent，求 base 的 exponent 次方。
     */
    public static double Power(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;
        boolean isNegative = false;
        if (exponent < 0) {
            isNegative = true;
            exponent *= (-1);
        }
        double ans = Power(base * base, exponent / 2);
        if (exponent % 2 != 0) {
            ans = ans * base;
        }
        return isNegative ? 1 / ans : ans;
    }
}
