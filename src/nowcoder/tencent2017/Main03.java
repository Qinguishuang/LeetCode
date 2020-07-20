package nowcoder.tencent2017;

import java.util.Arrays;
import java.util.Scanner;

public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n + 1];
        Arrays.fill(nums, 1);
        for (int i = 2; i < n; i++) {
            if (nums[i] == 1) {
                for (int j = 2; j * i < n; j++) {
                    nums[j * i] = 0;
                }
            }
        }
        int count = 0;
        for (int i = 2; i <= n / 2; i++) {
            if (nums[i] == 1 && nums[n - i] == 1)
                count++;
        }
        System.out.println(count);
    }
}
