package CS_Note.second.doublepointer;

import java.util.Arrays;
import java.util.HashMap;

public class No451 {
    public String frequencySort(String s) {
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        HashMap<Integer, String> nums = new HashMap<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                String str = nums.get(count[i]);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < count[i]; j++) {
                    sb.append((char) i);
                }
                if (str != null)
                    nums.put(count[i], sb.toString().concat(str));
                else
                    nums.put(count[i], sb.toString());
            }
        }
        Integer[] num = nums.keySet().toArray(new Integer[]{});
        Arrays.sort(num);
        StringBuilder sb = new StringBuilder();
        for (int i = num.length - 1; i >= 0; i--) {
            sb.append(nums.get(num[i]));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        No451 n = new No451();
        System.out.println(n.frequencySort("Aabb"));
    }
}
