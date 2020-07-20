package cz;

import java.util.Arrays;

public class No945 {
    public int minIncrementForUnique(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        Arrays.sort(A);
        int ans = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                int tmp = A[i];
                A[i] = A[i - 1] + 1;
                ans += A[i] - tmp;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        No945 n = new No945();
        int[] A = {3, 2, 1, 2, 1, 7};
        System.out.println(n.minIncrementForUnique(A));
    }
}
