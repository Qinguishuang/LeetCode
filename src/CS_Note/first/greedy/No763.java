package CS_Note.first.greedy;

import java.util.ArrayList;
import java.util.List;

public class No763 {
    public List<Integer> partitionLabels(String s) {
        if (s == null || s.length() == 0)
            return null;
        List<Integer> ans = new ArrayList<>();
        int[] lastIndexOfChar = new int[26];
        int i = 0, len = s.length(), index = 0;
        for (; i < len; i++) {
            lastIndexOfChar[s.charAt(i) - 'a'] = i;
        }
        i = 0;
        while (i < len) {
            index = lastIndexOfChar[s.charAt(i) - 'a'];
            for (int j = i + 1; j < index && j < len; j++) {
                if (lastIndexOfChar[s.charAt(j) - 'a'] > index) {
                    index = lastIndexOfChar[s.charAt(j) - 'a'];
                }
            }
            ans.add(index - i + 1);
            i = index + 1;
        }
        return ans;
    }
}
