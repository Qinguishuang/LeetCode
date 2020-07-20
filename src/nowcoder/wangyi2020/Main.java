package nowcoder.wangyi2020;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main15(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int times = sc.nextInt();
        int[] copy = Arrays.copyOf(nums, n);
        Arrays.sort(nums);
        for (int i = 0; i < times; i++) {
            int s = sc.nextInt();
            int count = 0;
            int score = copy[s - 1];
            for (int j = 0; j < n; j++) {
                if (nums[j] <= score) {
                    count++;
                } else {
                    break;
                }
            }
            System.out.printf("%.6f", (count - 1) * 1.0 / n * 100);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int times = sc.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = sc.nextInt();
        }
        for (int i = 0; i < times; i++) {
            Arrays.sort(nums);
            int x = sc.nextInt();
            int low = 0, high = len - 1;
            while (low < high) {
                int mid = (high - low) / 2;
                if (nums[mid] <= x) {
                    low = mid;
                } else if (nums[mid] > x) {
                    high = mid;
                }
            }
        }
    }
}
