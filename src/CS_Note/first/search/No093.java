package CS_Note.first.search;

import java.util.ArrayList;
import java.util.List;

public class No093 {
    /**
     * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
     */
    private List<String> ans = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {

        if (s == null || s.length() < 4 || s.length() > 12)
            return ans;
        restoreIpAddresses(new StringBuffer(s), 1, 1); // 从第1个字符开始, 插入第1个点
        return ans;
    }

    public void restoreIpAddresses(StringBuffer s, int start, int num) {
        if (num == 4) {
            if (isLegal(s, num)) {
                ans.add(s.toString());
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            s.insert(i, ".");
            if (isLegal(s, num)) {
                restoreIpAddresses(s, i + 2, num + 1);
            }
            s.deleteCharAt(i);
        }
    }

    public boolean isLegal(StringBuffer s, int num) {
        String[] tmp = s.toString().split("\\.");
        for (int i = 0; i < num; i++) {
            if (Long.parseLong(tmp[i]) > 255 || !String.valueOf(Long.parseLong(tmp[i])).equals(tmp[i]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        No093 n = new No093();
        n.restoreIpAddresses("010010");
        // n.restoreIpAddresses("111255");

        System.out.println(n.ans.toString()); //5525525525
    }
}
