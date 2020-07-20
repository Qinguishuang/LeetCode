package nowcoder.bytedance2019;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 判断麻将能否和牌
 * <p>
 * 回溯
 */
public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[9];
        int[] count = new int[9];
        for (int i = 0; i < 13; i++) { // 统计每张牌的出现次数
            count[sc.nextInt() - 1]++;
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if (count[i] < 4) {
                int num = i + 1;
                System.arraycopy(count, 0, nums, 0, 9);
                nums[i]++; // 依次添加一张牌, 判断能否胡牌
                if (canHu(nums, 14, false))
                    result.add(num);
            }
        }
        if (result.isEmpty())
            System.out.println(0);
        else {
            StringBuffer sbf = new StringBuffer();
            sbf.append(result.get(0));
            for (int i = 0; i < result.size(); i++) {
                sbf.append(" ");
                sbf.append(result.get(i));
            }
            System.out.println(sbf.toString());
        }

    }

    private static boolean canHu(int[] nums, int total, boolean hasHead) {
        if (total == 0)
            return true;
        if (!hasHead) { // 如果没有两张相同的牌
            for (int i = 0; i < 9; i++) {
                if (nums[i] >= 2) {
                    nums[i] -= 2;
                    if (canHu(nums, total - 2, true))
                        return true;
                    nums[i] += 2;
                }
            }
            return false;
        } else {
            for (int i = 0; i < 9; i++) {
                if (nums[i] > 0) {
                    if (nums[i] >= 3) {
                        nums[i] -= 3;
                        if (canHu(nums, total - 3, true))
                            return true;
                        nums[i] += 3;
                    }
                    if (i + 2 < 9 && nums[i + 1] > 0 && nums[i + 2] > 0) {
                        nums[i]--;
                        nums[i + 1]--;
                        nums[i + 2]--;
                        if (canHu(nums, total - 3, true))
                            return true;
                        nums[i]++;
                        nums[i + 1]++;
                        nums[i + 2]++;
                    }
                }
            }
            return false;
        }
    }
}
