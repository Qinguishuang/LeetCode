package sort;

public interface AllSort<T> {
    void bubbleSort(T[] nums);

    void selectSort(T[] nums);

    void insertSort(T[] nums);

    void mergeSort(T[] nums);

    void mergeSort(T[] nums, int l, int r);

    void quickSort(T[] nums, int l, int r);

    void shellSort(T[] nums);

    default public void swap(T[] nums, int i, int j) {
        T tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
