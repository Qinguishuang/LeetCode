package cz;

import java.util.ArrayList;
import java.util.List;

public class No022 {
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        int l = 0, r = 0;
        dfs(l, r, "", n);
        return ans;
    }

    private void dfs(int l, int r, String sb, int n) {
        if (sb.length() == n * 2) {
            ans.add(sb.toString());
        } else {
            if (l == r) {
                if (l < n) {
                    dfs(l + 1, r, sb + "(", n);
                }
            } else if (l > r) {
                if (l < n) {
                    dfs(l + 1, r, sb + "(", n);
                }
                dfs(l, r + 1, sb + ")", n);
            }
        }
    }

    public List<String> generateString(int n) {
        dfs(n, n, "");
        return ans;
    }

    public void dfs(int l, int r, String currStr) {
        if (l == 0 && r == 0) {
            ans.add(currStr);
        } else {
            if (l > 0) {
                dfs(l - 1, r, currStr + "(");
            }
            if (l > r) {
                dfs(l, r - 1, currStr + ")");
            }
        }
    }

    public static void main(String[] args) {
        No022 n = new No022();
        System.out.println(n.generateParenthesis(3));
    }
}
