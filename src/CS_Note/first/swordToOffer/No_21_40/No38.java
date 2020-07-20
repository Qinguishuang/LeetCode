package CS_Note.first.swordToOffer.No_21_40;

import java.util.ArrayList;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * https://uploadfiles.nowcoder.com/images/20170705/7578108_1499250116235_8F032F665EBB2978C26C4051D5B89E90
 */
public class No38 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> ans = new ArrayList<>();
        if (str == null || str.length() == 0)
            return ans;
        Permutation(str.toCharArray(), 0, ans);
        return ans;
    }

    public void Permutation(char[] chars, int i, ArrayList<String> list) {
        if (i == chars.length - 1) {
            list.add(String.valueOf(chars));
        } else {
            for (int j = i; j < chars.length; j++) {
                swap(chars, i, j);
                Permutation(chars, i + 1, list);
                swap(chars, i, j);
            }
        }
    }

    public void swap(char[] c, int i, int j) {
        char tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }

    public static void main(String[] args) {
        No38 n = new No38();
        System.out.println(n.Permutation("abc"));
    }
}
