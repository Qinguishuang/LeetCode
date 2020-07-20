package CS_Note.first.search;

import java.util.ArrayList;
import java.util.List;

public class No078_2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < (1 << nums.length); i++) { // n个数字, 共有2^n个子集
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (((i >> j) & 1) == 1) {
                    tmp.add(nums[j]);
                }
            }
            ans.add(tmp);
        }
        return ans;
    }
}
