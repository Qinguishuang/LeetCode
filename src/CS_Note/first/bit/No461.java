package CS_Note.first.bit;

public class No461 {
    public int hammingDistance(int x, int y) {
        int i = x ^ y;
        int ans = 0;
        while (i != 0) {
            i = i & (i - 1);
            ans ++;
        }
        return ans;
    }
}
