package CS_Note.second.sort;

public class Sort implements AllSort<Integer> {

    @Override
    public void bubbleSort(Integer[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    @Override
    public void selectSort(Integer[] nums) {
        int minIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            swap(nums, minIndex, i);
        }
    }

    @Override
    public void insertSort(Integer[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int index = i - 1;
            int num = nums[i];
            while (index >= 0 && nums[index] > num) {
                nums[index + 1] = nums[index];
                index--;
            }
            nums[index] = num;
        }
    }


    @Override
    public void mergeSort(Integer[] nums, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, r);
            merge(nums, l, mid, r);
        }
    }

    @Override
    public void quickSort(Integer[] nums, int l, int r) {
        if (l < r) {
            int index = partition(nums, l, r);
            quickSort(nums, l, index - 1);
            quickSort(nums, index + 1, r);
            merge(nums, l, index, r);
        }
    }

    private int partition(Integer[] nums, int l, int r) {
        int tmp = nums[l];
        while (l < r) {
            while (l < r && nums[tmp] <= nums[r])
                r--;
            nums[l] = nums[r];
            while (l < r && nums[tmp] >= nums[l])
                l++;
            nums[r] = nums[l];
        }
        nums[l] = tmp;
        return l;
    }

    private void merge(Integer[] nums, int l, int m, int r) {
        int[] tmp = new int[r - l + 1];
        int i = l, j = r + 1, k = 0;
        while (i <= m && j <= r) {
            if (nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }
        while (i <= m)
            tmp[k++] = nums[i++];
        while (j <= r)
            tmp[k++] = nums[j++];
        System.arraycopy(tmp, 0, nums, l, tmp.length);
    }

    @Override
    public void shellSort(Integer[] nums) {

    }

    @Override
    public void heapSort(Integer[] nums) {
        // 建大顶堆
        for (int i = nums.length / 2; i >= 0; i--) {
            adjustHeap(nums, i, nums.length);
        }
        // 调整堆
        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, 0, i);
            adjustHeap(nums, 0, i);
        }
    }

    private void adjustHeap(Integer[] nums, int i, int length) {
        int tmp = nums[i];
        // 从i节点的左子节点开始
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            // 如果左子节点小于右子节点， j指向右子节点
            if (j + 1 < length && nums[j] < nums[j + 1]) {
                j++;
            }
            // 如果子节点大于父节点，调整
            if (nums[j] > tmp) {
                nums[i] = nums[j];
                i = j;
            } else {
                break;
            }
        }
        nums[i] = tmp;
    }
}
