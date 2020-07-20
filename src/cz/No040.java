package cz;

public class No040 {
    public int[] getLeastNumbers(int[] arr, int k) {
        k = arr.length - k;
        quickSort(arr, 0, arr.length - 1, k);
        int[] ans = new int[k];
        System.arraycopy(arr, 0, ans, 0, k);
        return ans;
    }

    private void quickSort(int[] arr, int start, int end, int k) {
        if (start < end) {
            int index = partition(arr, start, end);
            if (index - start + 1 == k) {
                return;
            } else if (index - start + 1 < k) {
                quickSort(arr, index + 1, end, k - (index - start + 1));
            } else {
                quickSort(arr, start, index - 1, k);
            }
        }
    }

    private int partition(int[] arr, int start, int end) {
        int tmp = arr[start];
        while (start < end) {
            while (start < end && arr[end] >= tmp)
                end--;
            arr[start] = arr[end];
            while (start < end && arr[start] <= tmp)
                start++;
            arr[end] = arr[start];
        }
        arr[start] = tmp;
        return start;
    }
}
