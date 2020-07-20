package string;

import java.util.ArrayList;
import java.util.List;

public class No006 {
    public static void main(String[] args) {
        No006 n = new No006();
        n.convert("AB", 1).equals("LCIRETOESIIGEDHN");
    }

    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        List<StringBuilder> subStr = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            subStr.add(new StringBuilder());
        }
        int curRow = 0;
        boolean isDown = false;
        for (int i = 0; i < s.length(); i++) {
            subStr.get(curRow).append(s.charAt(i));
            if (curRow == 0 || curRow == numRows - 1)
                isDown = !isDown;
            curRow += isDown ? 1 : -1;
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder stringBuilder : subStr) {
            ans.append(stringBuilder);
        }
        return ans.toString();
    }
}
