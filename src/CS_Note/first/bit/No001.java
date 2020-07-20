package CS_Note.first.bit;

public class No001 {
    public void exchange(int m, int n) {
        n = n ^ m;
        m = n ^ m;
        n = n ^ m;
    }
}
