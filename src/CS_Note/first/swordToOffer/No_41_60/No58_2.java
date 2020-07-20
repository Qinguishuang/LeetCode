package CS_Note.first.swordToOffer.No_41_60;

public class No58_2 {

    public static void main(String[] args) {
        No58_2 n = new No58_2();
        System.out.println(n.LeftRotateString("abcdefg", 2)); // cdefgab
    }

    /**
     * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
     * abcWXYZ ->  WXYZabc
     * <p>
     * cbaZYXW -> WXYZabc
     */
    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0 || n <= 0)
            return str;
        if (n > str.length()) {
            n %= str.length();
        }
        StringBuffer sb = new StringBuffer(str);
        reverse(sb, 0, n - 1);
        reverse(sb, n, str.length() - 1);
        return sb.reverse().toString();
    }

    public void reverse(StringBuffer sb, int i, int j) {
        while (i < j) {
            char tmp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, tmp);
            i++;
            j--;
        }
    }
}
