package CS_Note.first.swordToOffer.No_21_40;


public class No33 {
    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 假设输入的数组的任意两个数字都互不相同。
     */
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return true;
        return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    public boolean VerifySquenceOfBST(int[] sequence, int start, int last) {
        if (start >= last)
            return true;
        int root = sequence[last];
        int index = start;
        for (int i = start; i < last; i++) {
            if (sequence[i] < root) {
                index  = i;
            } else {
                break;
            }
        }
        for (int i = index + 1; i < last; i++) {
            if (sequence[i] <= root) {
                return false;
            }
        }
        return VerifySquenceOfBST(sequence, start, index) && VerifySquenceOfBST(sequence, index + 1, last);
    }
}
