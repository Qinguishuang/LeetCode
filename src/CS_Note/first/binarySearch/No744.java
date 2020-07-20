package CS_Note.first.binarySearch;

public class No744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int h = letters.length - 1;
        while (l <= h) {
            int m = (l + h) / 2;
            if (letters[m] <= target) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        if (l < letters.length) {
            return letters[l];
        } else {
            return letters[0];
        }
    }
}
