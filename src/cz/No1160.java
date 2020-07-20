package cz;

public class No1160 {
    public int countCharacters(String[] words, String chars) {
        int[] all = count(chars);
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            int[] tmp = count(words[i]);
            if (contains(tmp, all)) {
                ans += words[i].length();
            }
        }
        return ans;
    }

    private boolean contains(int[] tmp, int[] words) {
        for (int i = 0; i < 26; i++) {
            if (tmp[i] > words[i])
                return false;
        }
        return true;
    }

    public int[] count(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        return count;
    }
}
