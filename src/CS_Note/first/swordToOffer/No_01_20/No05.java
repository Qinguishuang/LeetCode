package CS_Note.first.swordToOffer.No_01_20;

public class No05 {
    /**
     * 将一个字符串中的空格替换成 "%20"。
     */
    public String replaceSpace(StringBuffer str) {
        int len = str.length() - 1;
        for (int i = 0; i <= len; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(len) == ' ') {
                str.setCharAt(i--, '0');
                str.setCharAt(i--, '2');
                str.setCharAt(i, '%');
            } else {
                str.setCharAt(i, str.charAt(len));
            }
            len--;
        }
        return str.toString();
    }
}
