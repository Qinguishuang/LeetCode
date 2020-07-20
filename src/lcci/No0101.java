package lcci;

public class No0101 {
    public boolean isUnique(String astr) {
        int mark = 0; // 32位， 一共26个字母
        for (int i = 0; i < astr.length(); i++) {
            int move = astr.charAt(i) - 'a';
            if ((mark & (1 << move)) != 0) {
                return false;
            } else {
                mark |= (1 << move);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No0101 n = new No0101();
        System.out.println(n.isUnique("leet"));
    }
}
