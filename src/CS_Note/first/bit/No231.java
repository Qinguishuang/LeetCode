package CS_Note.first.bit;

public class No231 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0; // 只有一个1存在
    }
}
