package CS_Note.first.doublepointer;

public class No167 {

    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        if (numbers == null || numbers.length == 0)
            return ans;
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] < target) {
                i++;
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            } else {
                ans[0] = i + 1;
                ans[1] = j + 1;
                break;
            }
        }
        return ans;
    }
}
