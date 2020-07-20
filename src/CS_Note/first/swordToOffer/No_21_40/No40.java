package CS_Note.first.swordToOffer.No_21_40;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class No40 {
    /**
     * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     */
    private ArrayList<Integer> ans = new ArrayList<>();

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input == null || input.length == 0 || k <= 0 || k > input.length)
            return ans;
        GetLeastNumbers_Solution(input, 0, input.length - 1, k - 1);
        for (int i : IntStream.range(0, k).toArray()) {
            ans.add(input[i]);
        }
        return ans;
    }

    public void GetLeastNumbers_Solution(int[] input, int start, int end, int k) {
        if (start < end) {
            int index = partition(input, start, end);
            if (index - start + 1 > k)
                GetLeastNumbers_Solution(input, start, index - 1, k);
            else if (index - start + 1 < k)
                GetLeastNumbers_Solution(input, index + 1, end, k);
            else {

            }
        }
    }

    public int partition(int[] input, int start, int end) {
        int tmp = input[start];
        while (start < end) {
            while (start < end && input[end] >= tmp)
                end--;
            input[start] = input[end];
            while (start < end && input[start] <= tmp)
                start++;
            input[end] = input[start];
        }
        input[start] = tmp;
        return start;
    }

    public static void main(String[] args) {
        No40 n = new No40();
        // int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        int[] input = {4, 0, 0, 1, 2, 4, 2, 2, 3, 1};
        System.out.println(n.GetLeastNumbers_Solution(input, 8).toString());
    }
}
