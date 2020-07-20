package lcof.No_21_40;

public class No33 {
    public boolean verifyPostorder(int[] postorder) {
        return verify(postorder, 0, postorder.length - 1);
    }

    private boolean verify(int[] post, int start, int end) {
        if (start > end) {
            return true;
        }
        int root = post[end];
        int split = start;
        for (; split < end; split++) {
            if (post[split] > root) {
                break;
            }
        }
        for (int i = split; i < end; i++) {
            if (post[i] < root) {
                return false;
            }
        }
        return verify(post, start, split - 1) && verify(post, split, end - 1);
    }
}