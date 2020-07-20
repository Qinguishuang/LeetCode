package CS_Note.first.swordToOffer.No_41_60;

public class No58_1 {

    public static void main(String[] args) {
        No58_1 n = new No58_1();
        System.out.println(n.ReverseSentence("student. a am I"));
    }

    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0)
            return "";
        StringBuffer sb = new StringBuffer(str);
        sb.reverse();
        int l = 0, h = 0;
        while (h < str.length()) {
            if (sb.charAt(h) == ' ') {
                reverse(sb, l, h - 1);
                l = h + 1;
                h++;
            } else if (h == str.length() - 1) {
                reverse(sb, l, h);
                break;
            } else {
                h++;
            }
        }
        return sb.toString();
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
