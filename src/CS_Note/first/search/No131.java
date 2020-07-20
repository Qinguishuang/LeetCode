package CS_Note.first.search;

import java.util.ArrayList;
import java.util.List;

public class No131 {
    /**
     * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
     * <p>
     * 返回 s 所有可能的分割方案。
     */
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0)
            return ans;
        List<String> tmp = new ArrayList<>();
        backTracing(s, tmp);

        return ans;
    }

    public void backTracing(String s, List<String> tmp) {
        if (s.length() == 0) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isHuiwen(s, 0, i)) {
                tmp.add(s.substring(0, i + 1));
                backTracing(s.substring(i + 1), tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public boolean isHuiwen(String s, int begin, int end) {
        while (begin < end) {
            if (s.charAt(begin) != s.charAt(end)) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }
}
