package math;

public class No009 {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        String t = new StringBuffer(s).reverse().toString();
        return s.equals(t);
    }

    public boolean isPalindrome2(int x) {
        if (x < 0)
            return false;
        int ans = 0;
        int tmp = x;
        while (tmp != 0) {
            ans = ans * 10 + tmp % 10;
            tmp = tmp / 10;
        }
        return ans == x;
    }

    public boolean isPalindrome3(int x) {
        if (x < 0)
            return false;
        int count = 1; // 找到小于x的最大整数
        while (x / count >= 10)
            count *= 10;
        while (x != 0 && count != 0) {
            if (x % 10 != x / count) // 判断第一位和最后以为是否相等
                return false;
            x %= count;
            count /= 10;
        }
        return true;
    }
}
