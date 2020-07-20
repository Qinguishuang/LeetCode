package CS_Note.first.search;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class No052 {
    /**
     * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
     */

    private int ans = 0;
    private int queenNum = 0;
    private HashMap<Integer, Integer> position = new HashMap<>();

    public int totalNQueens(int n) {
        this.queenNum = n;
        if (n <= 2)
            return 0;
        getNum(0, 0);
        return ans;
    }

    public void getNum(int r, int c) {
        if (position.size() == queenNum) {
            ans++;
            return;
        }
        for (int i = r; i < queenNum; i++) {
            if (isLegal(i, c)) {
                position.put(i, c);
                getNum(i+1, c);
                position.remove(i);
            }
        }
    }

    public boolean isLegal(int r, int c) {
        Iterator iter = position.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            if (r == (int) entry.getKey() || c == (int) entry.getValue())
                return false;
        }
        return true;
    }

}
