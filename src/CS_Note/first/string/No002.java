package CS_Note.first.string;

public class No002 {
    public String move(String s, int k) {
        k = k % s.length();
        StringBuffer stringBuffer = new StringBuffer(s);
        int l = 0;
        int h = k;
        while (l < h) {
            char tmp = stringBuffer.charAt(l);
            stringBuffer.setCharAt(l, stringBuffer.charAt(h));
            stringBuffer.setCharAt(l, tmp);
        }
        l = k + 1;
        h = s.length() - 1;
        while (l < h) {
            char tmp = stringBuffer.charAt(l);
            stringBuffer.setCharAt(l, stringBuffer.charAt(h));
            stringBuffer.setCharAt(l, tmp);
        }
        return stringBuffer.reverse().toString();
    }
}
