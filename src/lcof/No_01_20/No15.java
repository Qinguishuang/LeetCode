package lcof.No_01_20;

public class No15 {
    // 1010
    // 1010 & 1001 = 1000
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count ++;
        }
        return count;
    }
}
