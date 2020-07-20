package cz;

import java.util.Arrays;

public class No914 {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck == null || deck.length == 0)
            return false;
        int[] count = new int[10000];
        for (int value : deck) {
            count[value]++;
        }
        return Arrays.stream(count).reduce(this::gcd).getAsInt() > 1;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
