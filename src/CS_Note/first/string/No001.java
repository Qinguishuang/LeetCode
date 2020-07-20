package CS_Note.first.string;

public class No001 {

    public boolean isHave(String s1, String s2) {
        s1 = s1 + s1;
        return s1.contains(s2);
    }
}
