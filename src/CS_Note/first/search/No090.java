package CS_Note.first.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No090 {
    /**
     * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        int subSetNum = 1 << nums.length;
        for (int i = 0; i < subSetNum; i++) { // n个数, 共有2^n个子集
            List<Integer> tmp = new ArrayList<>();
            boolean isLegal = false;
            for (int j = 0; j < nums.length; j++) {
                // 当前位是1 (需要加入)
                if (((i >> j) & 1) == 1) {
                    // 当前是重复数字, 前一位是0, 跳过  (第一位肯定要加入, 从第二位开始判断j>0)
                    if (j > 0 && nums[j] == nums[j - 1] && (i >> (j - 1) & 1) == 0) {
                        isLegal = true;
                        break;
                    } else {
                        tmp.add(nums[j]);
                    }
                }
            }
            if (!isLegal) {
                ans.add(tmp);
            }
        }
        return ans;
    }

    //当有重复数字的时候，我们只考虑上一步的新解
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>()); // 加入第一个空的
        Arrays.sort(nums);
        int start = 1; // 记录新解开始的位置
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> ans_tmp = new ArrayList<>();
            for (int j = 0; j < ans.size(); j++) {
                List<Integer> last = ans.get(j); // 记录上一个的长度
                // 出现重复, 跳过旧解
                if (i > 0 && nums[i] == nums[i - 1] && j < start) {
                    continue;
                }
                List<Integer> tmp = new ArrayList<>(last);
                // 加入本次新增数字
                tmp.add(nums[i]);
                ans_tmp.add(tmp);
            }
            // 更新新解位置
            start = ans.size();
            ans.addAll(ans_tmp);
        }
        return ans;
    }
}
