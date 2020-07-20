package CS_Note.first.array;

import java.util.Arrays;

public class No1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int index = 0;
        while (candies > 0) {
            ans[index % num_people] += Math.min(candies, index + 1);
            candies -= Math.min(candies, index + 1);
            index++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = new int[1];
        int b = 0;
        a[b++] = b;
        System.out.println(Arrays.toString(a));
    }
}
