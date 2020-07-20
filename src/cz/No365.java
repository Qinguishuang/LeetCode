package cz;

public class No365 {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0)
            return true;
        if (x + y < z)
            return false;
        if (x > y) { // x小， y大
            int tmp = x;
            x = y;
            y = tmp;
        }
        if (x == 0)
            return y == z;
        while (y % x != 0) { // 求最大公约数
            int tmp = y;
            y = x;
            x = tmp % x;
        }
        return z % x == 0;
    }
}
