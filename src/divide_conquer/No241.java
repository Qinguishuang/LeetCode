package divide_conquer;

import java.util.ArrayList;

public class No241 {
    /**
     * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。
     * 你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
     * <p>
     * Input: "2-1-1".
     * <p>
     * ((2-1)-1) = 0
     * (2-(1-1)) = 2
     */
    public ArrayList<Integer> diffWaysToCompute(String input) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                ArrayList<Integer> left = diffWaysToCompute(input.substring(0, i));
                ArrayList<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+': {
                                ans.add(l + r);
                                break;
                            }
                            case '-': {
                                ans.add(l - r);
                                break;
                            }
                            case '*': {
                                ans.add(l * r);
                                break;
                            }
                        }
                    }
                }
            }
        }
        if (ans.size() == 0) {
            ans.add(Integer.valueOf(input));
        }
        return ans;
    }
}
