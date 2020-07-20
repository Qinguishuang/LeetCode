package nowcoder.tencent2017;

import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        long[] arr = new long[32];
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt() - 1;
        int second = sc.nextInt() - 1;
        if (first >= 1024 || second >= 1024) {
            System.out.println(-1);
        }
        int f = first >> 5;
        int s = first & 31;
        arr[f] = arr[f] | (1 << s);

        int ff = second >> 5;
        int ss = second & 31;
        if ((arr[ff] >> ss & 1) == 1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }


}
