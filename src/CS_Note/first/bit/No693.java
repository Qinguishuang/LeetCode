package CS_Note.first.bit;

public class No693 {
    public boolean hasAlternatingBits(int n) {
        int a = (n ^ (n >> 1));
        return (a & (a + 1)) == 0;
        // 1010  -> 1010 ^ 0101 = 1111
        // 1111 & 0000 = 0

        // 0101 -> 0101 ^ 0010 = 0111
        // 0111 & 1000 = 0
    }
}
