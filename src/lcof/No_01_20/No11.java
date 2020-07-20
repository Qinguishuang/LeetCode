package lcof.No_01_20;

public class No11 {
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return 0;
        int low = 0, high = numbers.length - 1, mid = 0;
        int ans = numbers[0];
        while (low < high) {
            mid = low + (high - low) / 2;
            if (numbers[low] == numbers[mid] && numbers[mid] == numbers[high]) {
                return find(numbers, low, high);
            }
            if (numbers[mid] >= numbers[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return numbers[low];
    }

    private int find(int[] numbers, int low, int high) {
        int ans = numbers[low];
        for (int i = low; i <= high; i++) {
            if (numbers[i] < ans) {
                ans = numbers[i];
            }
        }
        return ans;
    }
}
