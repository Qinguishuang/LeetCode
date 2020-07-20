package lcof.No_41_60;

public class No46 {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int[] ans = new int[s.length() + 1];
        ans[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            ans[i + 1] += ans[i];
            if (i > 0) {
                if (s.charAt(i - 1) != '0' && s.substring(i - 1, i + 1).compareTo("25") <= 0) {
                    ans[i + 1] += ans[i - 1];
                }
            }
        }
        return ans[s.length()];
    }

    public int translateNum2(int num) {
        String s = String.valueOf(num);
        return dfs(0, s);
    }

    private int dfs(int begin, String s) {
        if (begin == s.length())
            return 1;
        int sum = dfs(begin + 1, s);
        if (begin + 1 < s.length() && s.charAt(begin) != '0' && s.substring(begin, begin + 1).compareTo("25") <= 0) {
            sum += dfs(begin + 2, s);
        }
        return sum;
    }

    public static void main(String[] args) {
        No46 n = new No46();
        System.out.println(n.translateNum(506));
    }
}
