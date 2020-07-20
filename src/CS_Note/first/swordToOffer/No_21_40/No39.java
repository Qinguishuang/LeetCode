package CS_Note.first.swordToOffer.No_21_40;

public class No39 {
    /**
     * 题目描述
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        int count = 1;
        int num = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] == num) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    num = array[i];
                    count = 1;
                }
            }
        }
        count = 0;
        for (int i : array) {
            if (i == num)
                count++;
        }
        if (count > array.length / 2)
            return num;
        else
            return 0;

    }

    public static void main(String[] args) {
        No39 n = new No39();
        int a = n.MoreThanHalfNum_Solution(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2});
        System.out.println(a);
    }
}
