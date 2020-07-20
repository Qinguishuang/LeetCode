package string;

public class No165 {

    public static void main(String[] args) {
        Integer.parseInt("012");
    }
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int i = 0, j = 0;
        while (i < v1.length && j < v2.length) {
            int first = Integer.parseInt(v1[i++]);
            int second = Integer.parseInt(v2[j++]);
            if (first != second) {
                return (first - second) > 0 ? 1 : -1;
            }
        }
        while (i < v1.length) {
            if (Integer.parseInt(v1[i++]) != 0) {
                return 1;
            }
        }
        while (j < v2.length) {
            if (Integer.parseInt(v2[j++]) != 0) {
                return -1;
            }
        }
        return 0;
    }

    public int compareVersion_(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int n1 = nums1.length, n2 = nums2.length;

        int i, j;
        for (int k = 0; k < Math.max(n1, n2); k++) {
            i = k < n1 ? Integer.parseInt(nums1[k]) : 0;
            j = k < n2 ? Integer.parseInt(nums2[k]) : 0;
            if (i != j) {
                return i > j ? 1 : -1;
            }
        }
        return 0;
    }

    /**
     * 每一个字符串用两个指针截取版本号
     */
    public int compareVersion__(String version1, String version2) {
        int i = 0, j = 0;
        while (i < version1.length() && j < version2.length()) {
            int x = i, y = j;
            while (x < version1.length() && version1.charAt(x) != '.')
                x++;
            while (y < version2.length() && version2.charAt(y) != '.')
                y++;
            int f = i == x ? 0 : Integer.parseInt(version1.substring(i, x));
            int s = j == y ? 0 : Integer.parseInt(version2.substring(j, y));
            if (f != s) {
                return f > s ? 1 : -1;
            }
            i = x + 1;
            j = y + 1;
        }
        return 0;
    }
}
