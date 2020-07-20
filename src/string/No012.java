package string;

public class No012 {
    public static void main(String[] args) {
        No012 n = new No012();
        System.out.println(n.intToRomanGreedy(1994));
    }

    /**
     * 贪心算法
     */
    public String intToRomanGreedy(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                ans.append(symbols[i]);
                num -= values[i];
            }
        }

        return ans.toString();
    }
}
