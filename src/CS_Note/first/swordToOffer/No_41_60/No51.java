package CS_Note.first.swordToOffer.No_41_60;

public class No51 {
    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
     * 输入一个数组,求出这个数组中的逆序对的总数P。
     */

    private int count = 0;
    private int[] tmp;

    public int InversePairs(int[] array) {
        tmp = new int[array.length];
        mergeSort(array, 0, array.length - 1);
        return count;
    }

    public void mergeSort(int[] array, int l, int h) {
        if (l < h) {
            int mid = l + (h - l) / 2;
            mergeSort(array, l, mid);
            mergeSort(array, mid + 1, h);
            merge(array, l, mid, h);
        }
    }

    public void merge(int[] array, int l, int m, int h) {
        int i = l, j = m + 1, k = l;
        while (i <= m || j <= h) {
            if (i > m) {
                tmp[k] = array[j++];
            } else if (j > h) {
                tmp[k] = array[i++];
            } else if (array[i] <= array[j]) {
                tmp[k] = array[i++];
            } else {
                tmp[k] = array[j++];
                count += (m - i + 1);
            }
            k++;
        }
        System.arraycopy(tmp, l, array, l, h-l+1);
    }


    public static void main(String[] args) {
        int[] array = {364, 637, 341, 406, 747, 995, 234, 971, 571, 219, 993, 407, 416, 366, 315, 301, 601,
                650, 418, 355, 460, 505, 360, 965, 516, 648, 727, 667, 465, 849, 455, 181, 486, 149, 588, 233,
                144, 174, 557, 67, 746, 550, 474, 162, 268, 142, 463, 221, 882, 576, 604, 739, 288, 569, 256,
                936, 275, 401, 497, 82, 935, 983, 583, 523, 697, 478, 147, 795, 380, 973, 958, 115, 773, 870,
                259, 655, 446, 863, 735, 784, 3, 671, 433, 630, 425, 930, 64, 266, 235, 187, 284, 665, 874,
                80, 45, 848, 38, 811, 267, 575};
        // array = new int[]{3, 4, 7, 8, 5, 6, 9, 10};
        No51 n = new No51();
        System.out.println(n.InversePairs(array));
    }
}
