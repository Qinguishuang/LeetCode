package lcof.No_41_60;

public class No58 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(n));
        sb.append(s.substring(0, n));
        return sb.toString();
    }
}
