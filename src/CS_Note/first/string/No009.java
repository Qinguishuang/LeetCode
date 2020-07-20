package CS_Note.first.string;

public class No009 {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int i = 1;
        while (x / i >= 10) {
            i *= 10;
        }
        while (x != 0) {
            if (x / i != x % 10)
                return false;
            x %= i;
            x /= 10;
            i /= 100;
        }
        return true;
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

    public static void main(String[] args) {
        No009 n = new No009();
        System.out.println(n.isPalindrome2(1234));
    }
}
