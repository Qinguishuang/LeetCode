package book.chapter1;

import java.util.LinkedList;

/**
 * 求
 * max(arr[i...j]) - min(arr[i...j]) <= num
 * 个数
 * 维护两个栈分别记录 arr[i...j] 最大值最小值
 */
public class No010 {

    public int getNum(int[] arr, int num) {
        if (arr == null || arr.length == 0 || num < 0)
            return 0;
        int res = 0;
        LinkedList<Integer> maxQueue = new LinkedList<>();
        LinkedList<Integer> minQueue = new LinkedList<>();
        int i = 0, j = 0;
        for (; i < arr.length; i++) {
            for (; j < arr.length; j++) {
                // 记录arr[i...j]的最小值
                if (!minQueue.isEmpty() || minQueue.peekLast() != j) {
                    while (!minQueue.isEmpty() && arr[minQueue.peekLast()] >= arr[j]) {
                        minQueue.pollLast();
                    }
                }
                minQueue.addLast(j);
                // 最大值
                if (!maxQueue.isEmpty() || maxQueue.peekLast() != j) {
                    while (!maxQueue.isEmpty() && arr[maxQueue.peekLast()] <= arr[j]) {
                        maxQueue.pollLast();
                    }
                }
                maxQueue.addLast(j);
                if (arr[maxQueue.getFirst()] - arr[minQueue.getFirst()] > num) {
                    break;
                }
            }
            res += (j - i);
            if (minQueue.peekFirst() == i) {
                minQueue.pollFirst();
            }
            if (maxQueue.peekFirst() == i) {
                maxQueue.pollFirst();
            }
        }
        return res;
    }

}
