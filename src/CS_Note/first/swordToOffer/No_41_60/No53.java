package CS_Note.first.swordToOffer.No_41_60;

public class No53 {
    /**
     * 统计一个数字在排序数组中出现的次数。
     */
    public int GetNumberOfK(int[] array, int k) {
        if (array == null)
            return 0;
        return getPosition(array, k + 0.5) - getPosition(array, k - 0.5);
    }

    public int getPosition(int[] array, double k) {
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low ) / 2;
            if (array[mid] < k) {
                low = mid + 1;
            } else if (array[mid] > k) {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        No53 n = new No53();
        System.out.println(n.GetNumberOfK(new int[]{3, 3, 3, 3, 4, 5}, 3));
    }
}
