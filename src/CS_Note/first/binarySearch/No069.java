package CS_Note.first.binarySearch;

public class No069 {
    public int mySqrt(int x) {
        int h = x / 2;
        int l = 0;

        while (h >= l) {
            int m = (h + l) / 2;
            if (m * m > x) {
                h = m - 1;
            } else if (m * m < x) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return h;
    }

    /**
     * x=8, ans=2
     *
     * l    m   h
     * 0        4
     *      2       2*2<8, l=m+1
     * 3        4
     *      3       3*3>8, h=m-1
     * 3        2   break;
     */
}
