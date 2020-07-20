package lcci;

public class No0106 {
    public String compressString(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }
        StringBuilder ans = new StringBuilder();
        int tmp = 1;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i - 1) == S.charAt(i)) {
                tmp++;
            } else {
                ans.append(S.charAt(i - 1)).append(tmp);
                tmp = 1;
            }
        }
        ans.append(S.charAt(S.length() - 1)).append(tmp);
        if (ans.length() < S.length()) {
            return ans.toString();
        } else {
            return S;
        }
    }

    public static void main(String[] args) {
        No0106 n = new No0106();
        System.out.println(n.compressString("abbbbcccc"));
    }
}
