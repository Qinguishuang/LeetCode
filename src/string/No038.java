package string;

public class No038 {
    public static void main(String[] args) {
        No038 n = new No038();
        System.out.println(n.countAndSay(5));
    }

    /**
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     */
    public String countAndSay(int n) {
        StringBuilder temp = new StringBuilder("1");
        StringBuilder ans = new StringBuilder();
        int count = 1;
        for (int i = 2; i <= n; i++) { // 遍历n次
            for (int j = 1; j < temp.length(); j++) {

                if (temp.charAt(j) == temp.charAt(j - 1)) {
                    count++;
                } else {
                    ans.append(count);
                    ans.append(temp.charAt(j - 1));

                    count = 1;
                }
            }
            if (count != 0) {
                ans.append(count);
                ans.append(temp.charAt(temp.length() - 1));
                count = 1;
            }
            temp = new StringBuilder(ans);
            ans.setLength(0);
        }

        return temp.toString();
    }
}
