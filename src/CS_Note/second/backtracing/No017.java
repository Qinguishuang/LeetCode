package CS_Note.second.backtracing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No017 {
    private List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return ans;

        Map<Character, String> map = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        StringBuffer s = new StringBuffer();
        backTracing(digits, 0, map, s);
        return ans;
    }

    private void backTracing(String digits, int i, Map<Character, String> map, StringBuffer s) {
        if (s.length() == digits.length()) {
            ans.add(s.toString());
            return;
        }
        for (int j = i; j < digits.length(); j++) {
            String str = map.get(digits.charAt(j));
            for (int k = 0; k < str.length(); k++) {
                s.append(str.charAt(k));
                backTracing(digits, j+1, map, s);
                s.deleteCharAt(s.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        No017 n = new No017();
        System.out.println(n.letterCombinations("23"));
    }
}
