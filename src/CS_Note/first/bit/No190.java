package CS_Note.first.bit;

public class No190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans <<= 1; // 最后一位补0
            ans += n & 1; // 判断原来数字的最后一位是0还是1, 然后加到最后一位
            n >>= 1; //将原来数字右移以为去掉最后一位
        }
        return ans;
    }
}
