package lcof.No_41_60;

public class No58_1 {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = str.length-1; i >= 0 ; i--) {
            if (str[i].trim().length() > 0)
                sb.append(str[i].trim()).append(" ");
        }
        return sb.toString().trim();
    }
}
