package nowcoder.tencent2017;

import java.util.Scanner;

public class Main04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int low = -90;
        int high = 90;
        int mid;
        StringBuilder s = new StringBuilder();
        while (low < high) {
            mid = (low + high) / 2;
            if (mid > n) {
                s.append(1);
                low = mid;
            } else if (mid < n) {
                s.append(0);
                high = mid - 1;
            } else {
                break;
            }
        }
        System.out.println(s);
    }
}
