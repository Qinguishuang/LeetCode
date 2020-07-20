package CS_Note.first.string;

public class No205 {
    // 记录上一次出现的位置
    public boolean isIsomorphic(String s, String t) {
        int[] countS = new int[256];
        int[] countT = new int[256];

        for (int i = 0; i < s.length(); i++) {
            if (countS[s.charAt(i)] != countT[t.charAt(i)]) {
                return false;
            } else {
                countS[s.charAt(i)] = i + 1;
                countT[t.charAt(i)] = i + 1;
            }
        }
        return true;
    }
}
