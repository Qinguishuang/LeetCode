package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 堆排序
 * 不稳定
 * 空间复杂度 O(n * log(n))
 * 数组从0开始 i的子节点 (i*2+1, i*2+1)
 * <p>
 * 升序: 大顶堆
 * 降序: 小顶堆
 * https://www.cnblogs.com/chengxiao/p/6129630.html
 */
public class HeapSort {

    public static void heapSort(int[] nums) {
        // 构建大顶堆
        for (int i = nums.length / 2; i >= 0; i--) {
            // 从最后一个非叶子节点开始, 从下往上
            adjustHeap(nums, i, nums.length);
        }
        // 调整堆的结构, 交换堆顶元素和末尾元素
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            adjustHeap(nums, 0, i); // 交换完成后重新调整堆
        }
    }


    /**
     * 调整堆(上浮)
     *
     * @param nums   所有元素
     * @param i      第i个元素需要调整
     * @param length 经过调整后还有length个元素无序
     */
    private static void adjustHeap(int[] nums, int i, int length) {
        int tmp = nums[i]; // 取出当前元素
        // 从i节点的左子节点开始
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            // 如果左子节点小于右子节点, k指向右子节点
            if (k + 1 < length && nums[k] < nums[k + 1]) {
                k++;
            }
            // 如果子节点大于父节点, 将子节点赋值给父节点
            if (nums[k] > tmp) {
                nums[i] = nums[k];
                i = k;
            } else {
                break;
            }
        }
        nums[i] = tmp;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {
        int[] nums = new int[20];
        Random r = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = r.nextInt(nums.length);
        }

        // int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(nums));
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
