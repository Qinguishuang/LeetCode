package star;

public class No067 {
    public String addBinary(String a, String b) {
        StringBuilder s = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            int sum = 0;
            if (i >= 0)
                sum += a.charAt(i --) - '0';
            if (j >= 0)
                sum += b.charAt(j --) - '0';
            sum += carry;
            carry = sum / 2;
            s.append(sum % 2);
        }
        if (carry == 1) {
            s.append(1);
        }
        return s.reverse().toString();
    }

    public static void main(String[] args) {
        No067 n = new No067();
        // System.out.println(n.addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
        //         "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
        System.out.println(n.addBinary("1000", "10"));
    }
}
