package CS_Note.first.string;

public class No003 {
    public String reverseString(String s) {
        StringBuffer sBuffer = new StringBuffer(s);
        int l = 0;
        int h = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ' || i == s.length() - 1) {
                reverse(sBuffer, l, i - 1);
            }
        }
        return sBuffer.reverse().toString();
    }

    public void reverse(StringBuffer s, int l, int h) {

    }
}
