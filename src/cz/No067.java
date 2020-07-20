package cz;

public class No067 {
    public String addBinary(String a, String b) {
        int lenA = a.length() - 1;
        int lenB = b.length() - 1;

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (lenA >= 0 || lenB >= 0) {
            int sum = 0;
            if (lenA >= 0)
                sum += (a.charAt(lenA --) - '0');
            if (lenB >= 0)
                sum += (b.charAt(lenB --) - '0');
            sum += carry;
            carry = sum / 2;
            sb.append(sum % 2);
        }
        if (carry == 1)
            sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        No067 n = new No067();
        // System.out.println(n.addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
        //         "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
        System.out.println(n.addBinary("1010", "10"));
    }
}
