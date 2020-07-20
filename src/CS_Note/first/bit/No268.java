package CS_Note.first.bit;

public class No268 {
    public int missingNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ i ^ nums[i];
        }
        return ans ^ nums.length;
    }
}
