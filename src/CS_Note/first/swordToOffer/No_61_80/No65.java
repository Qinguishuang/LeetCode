package CS_Note.first.swordToOffer.No_61_80;

public class No65 {
    // (a^b) ^ ((a&b)<<1)
    // 位运算求和
    public int add(int a, int b) {
        while (b != 0) {
            int add = (a ^ b); // 不进位求和
            b = ((a & b) << 1);
            a = add;
        }
        return a;
    }
}
