package CS_Note.first.swordToOffer.No_41_60;

import java.util.ArrayList;

public class No57_2 {
    /**
     * 输出所有和为 S 的连续正数序列。
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (sum <= 0)
            return ans;
        int low = 1, high = 2, currSum = 3;
        while (high < sum) {
            if (currSum > sum) {
                currSum -= low;
                low++;
            } else if (currSum < sum) {
                high++;
                currSum += high;
            } else {
                ArrayList<Integer> tmp = new ArrayList<>();
                for (int i = low; i <= high; i++) {
                    tmp.add(i);
                }
                ans.add(tmp);
                currSum -= low;
                low++;
                high++;
                currSum += high;
            }

        }
        return ans;
    }
}
