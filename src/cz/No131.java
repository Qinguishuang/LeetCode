package cz;

import java.util.ArrayList;
import java.util.List;

public class No131 {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0)
            return ans;
        List<String> tmp = new ArrayList<>();
        backTracing(tmp, s);
        return ans;
    }

    private void backTracing(List<String> tmp, String s) {
        if (s.length() == 0) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isHuiWen(s, 0, i)) {
                tmp.add(s.substring(0, i + 1));
                backTracing(tmp, s.substring(i + 1));
                tmp.remove(tmp.size() - 1);
            }
        }

    }

    private boolean isHuiWen(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
