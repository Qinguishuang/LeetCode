package cz;

public class No151 {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0)
            return s;
        StringBuilder sb = trimStr(s);
        reverseAll(sb, 0, sb.length() - 1); // 整个字符串翻转
        reverseWord(sb);
        return sb.toString();
    }

    private StringBuilder trimStr(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r && s.charAt(l) == ' ') l++;
        while (l <= r && s.charAt(r) == ' ') r--;
        StringBuilder sb = new StringBuilder();
        for (int i = l; i <= r; i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                sb.append(c);
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(" ");
            }
        }
        return sb;
    }

    private void reverseWord(StringBuilder sb) {
        int l = 0, r = 0;
        int len = sb.length();
        while (r < len) {
            while (r < len && sb.charAt(r) != ' ') {
                r++;
            }
            reverseAll(sb, l, r - 1);
            l = r + 1;
            r++;
        }
    }

    public void reverseAll(StringBuilder sb, int i, int j) {
        while (i < j) {
            char tmp = sb.charAt(i);
            sb.setCharAt(i++, sb.charAt(j));
            sb.setCharAt(j--, tmp);
        }
    }

    public static void main(String[] args) {
        No151 n = new No151();
        System.out.println(n.reverseWords(" "));
    }

}
