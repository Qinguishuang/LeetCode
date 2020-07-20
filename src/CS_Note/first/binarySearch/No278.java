package CS_Note.first.binarySearch;

public class No278 {
    public int firstBadVersion(int n) {
        int l = 1, h = n, mid = 0;
        while (l < h) {
            mid = l + (h - l) / 2;
            if (isBadVersion(mid)) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean isBadVersion(int version) {
        return false;
    }
}
