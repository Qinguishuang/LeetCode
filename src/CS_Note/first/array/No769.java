package CS_Note.first.array;

public class No769 {
    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int max = 0;
        int count = 0;
        int i = 0;
        while (i < arr.length) {
            max = arr[i];
            while (i < arr.length && i <= max) {
                if (arr[i] > max) {
                    max = arr[i];
                }
                i++;
            }
            count++;
        }
        return count;
    }

    public int maxChunksToSorted2(int[] arr) {
        int ans = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i)
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        No769 n = new No769();
        System.out.println(n.maxChunksToSorted(new int[]{1, 0, 2, 3, 4}));
    }
}
