package string;

public class No415 {

    public static void main(String[] args) {
        No415 n = new No415();
        System.out.println(n.addStrings("12345", "567"));
    }

    public String addStrings(String num1, String num2) {
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                carry += (num1.charAt(i) - '0');
                i--;
            }
            if (j >= 0) {
                carry += (num2.charAt(j) - '0');
                j--;
            }
            ans.append(carry % 10);
            carry = carry / 10;
        }
        if (carry != 0) {
            ans.append(carry);
        }
        return ans.reverse().toString();
    }
}
