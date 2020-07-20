package CS_Note.first.swordToOffer.No_01_20;

public class No17 {

    public static void main(String[] args) {
        print1ToMaxOfNDigits(2);
    }

    public static void print1ToMaxOfNDigits(int n) {
        char[] num = new char[n];
        print1ToMaxOfNDigits(num, 0);
    }

    public static void print1ToMaxOfNDigits(char[] nums, int digit) {
        if (digit == nums.length) {
            printNum(nums);
            return;
        }
        for (int i = 0; i < 10; i++) {
            nums[digit] = (char) (i + '0');
            print1ToMaxOfNDigits(nums, digit + 1);
        }
    }

    public static void printNum(char[] nums) {
        int index = 0;
        while (index < nums.length && nums[index] == '0') {
            index ++;
        }
        while (index < nums.length)
            System.out.print(nums[index ++]);
        System.out.println();
    }
}
