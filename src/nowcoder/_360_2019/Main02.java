package nowcoder._360_2019;

import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            if (nums[i] > max) {
                sum += max;
                max = nums[i];
            } else {
                sum += nums[i];
            }
            if (sum > max) {
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println(-1);
    }

}
