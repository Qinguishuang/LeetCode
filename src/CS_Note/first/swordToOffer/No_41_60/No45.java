package CS_Note.first.swordToOffer.No_41_60;

import java.util.Arrays;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class No45 {
    public String PrintMinNumber(int[] numbers) {
        StringBuilder stringBuilder = new StringBuilder();
        if (numbers == null || numbers.length == 0)
            return "";
        int len = numbers.length;
        String[] nums = new String[len];
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.toString(numbers[i]);
        }
        // Arrays.sort(nums, new Comparator<String>() {
        //     @Override
        //     public int compare(String o1, String o2) {
        //         String c1 = o1 + o2;
        //         String c2 = o2 + o1;
        //         return c1.compareTo(c2);
        //     }
        // });
        Arrays.sort(nums, (s1, s2) -> (s1 + s2).compareTo((s2 + s1)));
        for (String s : nums) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
