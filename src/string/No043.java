package string;

public class No043 {
    public static void main(String[] args) {
        No043 n = new No043();
        System.out.println(n.multiply_("12", "345"));

    }

    public String multiply(String num1, String num2) {
        StringBuilder ans = new StringBuilder("0");
        for (int i = num2.length() - 1; i >= 0; i--) {
            StringBuilder tmp = new StringBuilder();
            tmp.append("0".repeat(num2.length() - 1 - i)); // 先补上零
            int carry = 0;
            for (int j = num1.length() - 1; j >= 0; j--) { // 相乘
                carry += (num1.charAt(j) - '0') * (num2.charAt(i) - '0');
                tmp.append(carry % 10);
                carry = carry / 10;
            }
            if (carry != 0) {
                tmp.append(carry);
            }
            if (tmp.toString().equals("0".repeat(tmp.length()))) {
                tmp = new StringBuilder("0");
            }
            ans = addStrings(tmp.reverse(), ans);
        }
        return ans.toString();
    }

    public StringBuilder addStrings(StringBuilder num1, StringBuilder num2) {
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
        return ans.reverse();
    }

    /**
     * 优化
     */
    public String multiply_(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = (res[i + j + 1] + n1 * n2);
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) continue;
            result.append(res[i]);
        }
        return result.toString();
    }

}
