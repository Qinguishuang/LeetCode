package CS_Note.first.swordToOffer.No_01_20;

public class No19 {
    /**
     * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
     * 而'*'表示它前面的字符可以出现任意次（包含0次）。
     * 在本题中，匹配是指字符串的所有字符匹配整个模式。
     * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
     */
    public boolean match(char[] str, char[] pattern) {
        if (str == null || str.length <= 0 || pattern == null)
            return false;
        int strIndex = 0;
        int patternIndex = 0;
        return match(str, strIndex, pattern, patternIndex);
    }

    public boolean match(char[] str, int strIndex, char[] pattern, int patternIndex) {
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        if (strIndex != str.length && patternIndex == pattern.length)
            return false;
        // 第二个字符是*
        // 模式后移两位  a*b bbb
        // 字符串后移一位, 模式后移两位  a*b  abb
        // 字符串后移一位, 模式不变     a*b  aab
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if (strIndex != str.length && pattern[patternIndex] == str[strIndex] ||
                    pattern[patternIndex] == '.' && strIndex != str.length) {
                return match(str, strIndex, pattern, patternIndex + 2) ||
                        match(str, strIndex + 1, pattern, patternIndex + 2) ||
                        match(str, strIndex + 1, pattern, patternIndex);
            } else {
                return match(str, strIndex, pattern, patternIndex + 2);
            }
        }
        // 第二位不是*, 字符串和模式匹配一个字符, 都后移一位
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) ||
                (pattern[patternIndex] == '.' && strIndex != str.length))
            return match(str, strIndex + 1, pattern, patternIndex + 1);
        return false;
    }
}
