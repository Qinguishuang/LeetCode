package CS_Note.first.swordToOffer.No_41_60;

public class No49 {

    public static void main(String[] args) {
        No49 n = new No49();
        n.GetUglyNumber_Solution(15);
    }

    /**
     * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
     * 例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。
     * 求按从小到大的顺序的第N个丑数。
     */
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0)
            return 0;
        int[] nums = new int[index + 1];
        nums[1] = 1;
        int i2 = 1, i3 = 1, i5 = 1;
        for (int i = 2; i <= index; i++) {
            int next2 = nums[i2] * 2, next3 = nums[i3] * 3, next5 = nums[i5] * 5;
            nums[i] = Math.min(Math.min(next2, next3), next5);
            if (nums[i] == next2)
                i2++;
            if (nums[i] == next3)
                i3++;
            if (nums[i] == next5)
                i5++;
        }
        return nums[index];
    }
}
