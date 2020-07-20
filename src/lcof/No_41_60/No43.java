package lcof.No_41_60;

public class No43 {
    public int countDigitOne(int n) {
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            sb.append(i);
            if (i % 50 == 0) {
                int len = sb.length();
                ans += len - sb.toString().replace("1", "").length();
                sb.setLength(0);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "1";
        System.out.println(s.split("1").length);
    }
}
