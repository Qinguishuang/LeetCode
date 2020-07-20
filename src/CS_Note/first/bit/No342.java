package CS_Note.first.bit;

public class No342 {
    public boolean isPowerOfFour(int num) {
        if (num < 0 || (num & (num - 1)) == 0) // 去掉 0001 2的幂
            return false;
        return (num & 0x55555555) == num; // 只有奇数位为1  0100 -> 4
    }
}
