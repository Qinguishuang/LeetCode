package CS_Note.first.swordToOffer.No_41_60;

/**
 * 连续子数组的最大和
 */
public class No42 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        int ans = array[0];
        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (sum < 0) {
                sum = array[i];
            } else {
                sum += array[i];
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
