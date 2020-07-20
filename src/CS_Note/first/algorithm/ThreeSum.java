package CS_Note.first.algorithm;

import java.util.Arrays;

/**
 * 统计一个数组中和为 0 的三元组数量。 O(n^3)
 */
public class ThreeSum {
    /**
     * 三层循环
     */
    public int count(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0)
                        count++;
                }
            }
        }
        return count;
    }

    /**
     * 对数组进行排序, 其中两个求和, 二分法查找其相反数
     * (只有当数组中不含相同元素时才能使用)
     * O(n^2 * log(n))
     */
    public int count2(int[] nums) {
        Arrays.sort(nums); // 先排序
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int target = 0 - nums[i] - nums[j]; // 相反数
                int index = binarySearch(nums, target); // 二分查找
                if (index > j) // 找到的下标应该在j后面, 否则会重复
                    count++;
            }
        }
        return count;
    }

    private int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 先将数组排序, 双指针查找
     * 不能存在重复元素
     * O(n^2)
     */
    public int count3(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {// 遍历到倒数第三个元素停止
            int l = i + 1, h = nums.length - 1, target = -nums[i];
            while (l < h) {
                if (nums[l] + nums[h] == target) { // 找到了
                    count++;
                    l++;
                    h--;
                } else if (nums[l] + nums[h] < target) {
                    l++;
                } else {
                    h--;
                }
            }
        }
        return count;
    }

}
