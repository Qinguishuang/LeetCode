package sort;

import java.util.Arrays;
import java.util.Random;

public class MySort implements AllSort<Integer> {

    /**
     * 冒泡排序
     * <p>
     * 稳定
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(1)
     */
    @Override
    public void bubbleSort(Integer[] nums) {
        boolean isSorted = false;
        for (int i = 0; i < nums.length && !isSorted; i++) {
            isSorted = true;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    isSorted = false;
                }
            }
        }
    }

    /**
     * 选择排序
     * <p>
     * 不稳定 [7 3 4 7 1](两个7不稳定)
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(1)
     */
    @Override
    public void selectSort(Integer[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) { // 找出后面最小值的下标
                    min = j;
                }
            }
            if (i != min)
                swap(nums, i, min);
        }
    }

    /**
     * 插入排序
     * <p>
     * 稳定
     * 时间复杂度 (N - N^2) 和初始顺序有关
     * 空间复杂度 O(1)
     */
    @Override
    public void insertSort(Integer[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i];
            int j = i - 1;
            while (j >= 0 && tmp < nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = tmp;
        }
    }

    /**
     * 归并排序 (自底向上)
     *
     * @param nums
     */
    @Override
    public void mergeSort(Integer[] nums) {
        for (int i = 1; i < nums.length; i *= 2) { // 1, 2, 4, 8
            for (int j = 0; j < nums.length - i; j += (i * 2)) {
                merge(nums, j, j + i - 1, Math.min(j + i + i - 1, nums.length - 1));
            }
        }
    }

    /**
     * 归并排序
     * <p>
     * 不稳定
     * 时间复杂度 O(n * log(n))
     * O(n) = O(n/2) + O(n/2) + O(n)
     * = O(n/4) + O(n/4) + 2O(n)
     * 空间复杂度 O(n)
     */
    @Override
    public void mergeSort(Integer[] nums, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, r);
            merge(nums, l, mid, r);
        }
    }

    private void merge(Integer[] nums, int l, int mid, int r) {
        Integer[] tmp = new Integer[r - l + 1];
        int i = l, j = mid + 1, k = 0;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }
        while (i <= mid)
            tmp[k++] = nums[i++];
        while (j <= r)
            tmp[k++] = nums[j++];
        System.arraycopy(tmp, 0, nums, l, k);
    }

    /**
     * 快速排序
     * <p>
     * 不稳定
     * 时间复杂度:
     * 最好 O(n * log(n)) 每次partition都找到中间
     * 最坏 O(n^2 / 2) 已经排好序
     * 空间复杂度: log(n)
     */
    @Override
    public void quickSort(Integer[] nums, int l, int r) {
        if (l < r) {
            int index = partition(nums, l, r);
            quickSort(nums, l, index);
            quickSort(nums, index + 1, r);
        }
    }

    private int partition(Integer[] nums, int l, int r) {
        int tmp = nums[l];
        while (l < r) {
            while (r > l && nums[r] >= tmp) {
                r--;
            }
            nums[l] = nums[r];
            while (l < r && nums[l] <= tmp) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = tmp;
        return l;
    }

    /**
     * 希尔排序
     * <p>
     * 不稳定
     */
    @Override
    public void shellSort(Integer[] nums) {
        for (int i = nums.length / 2; i > 0; i /= 2) {
            for (int j = i; j < nums.length; j++) {
                int k = j;
                while (k - i >= 0 && nums[k] < nums[k - i]) {
                    swap(nums, k, k - i);
                    k -= i;
                }
            }
        }
    }


    public static void main(String[] args) {
        MySort m = new MySort();
        Integer[] nums = new Integer[20];
        Random r = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = r.nextInt(nums.length);
        }

        System.out.println(Arrays.toString(nums));

        // m.bubbleSort(nums);
        // m.insertSort(nums);
        // m.mergeSort(nums, 0, nums.length - 1);
        m.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
