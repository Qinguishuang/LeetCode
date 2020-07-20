package CS_Note.first.bit;

public class No476 {
    public int findComplement(int num) {
        int n = 1; // 找到和num位数一样的全1
        int tmp = num;
        while (tmp > 0) {
            n <<= 1;
            tmp >>= 1;
        }
        n -= 1;
        return n ^ num;
    }
}
