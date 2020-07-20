package CS_Note.first.array;

public class No1013 {
    /**
     * 首先 count == 3 就说明找到了三个和为 sum / 3 的子数组，那剩下元素的和就只能为 0 了，
     * 把它们合并到最后一个子数组就 OK 啦。
     */
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int value : A) {
            sum += value;
        }
        if (sum % 3 != 0)
            return false;
        sum /= 3;
        int tmp = 0;
        int count = 0;
        for (int i = 0; i < A.length; i++) { // [0, 0]不满足
            tmp += A[i];
            if (tmp == sum) {
                count++;
                tmp = 0;
                if (count > 2)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
