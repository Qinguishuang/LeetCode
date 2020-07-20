package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class Test {

    public static void main(String[] args) {
        double[] array = new double[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random() * array.length;
        }
        bucketSort(array);
    }

    private static void bucketSort(double[] array) {
        // 创建桶 [[1, 2, 5], [12, 16, 19], [22, 24, 27]]
        ArrayList<LinkedList<Double>> buckets = new ArrayList<LinkedList<Double>>();
        for (int i = 0; i < array.length; i++) {
            buckets.add(new LinkedList<Double>());
        }
        // 将元素放入桶, 桶内插入排序
        for (double v : array) {
            int index = (int) v;
            insertBucket(buckets.get(index), v);
        }
        // 将桶中元素放入原始array
        int index = 0;
        for (LinkedList<Double> bucket : buckets) {
            for (Double aDouble : bucket) {
                array[index++] = aDouble;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * 桶内选择排序
     */
    private static void insertBucket(LinkedList<Double> list, Double data) {
        ListIterator<Double> lt = list.listIterator();
        boolean isInsert = false;
        while (lt.hasNext()) {
            if (data <= lt.next()) {
                lt.previous();
                lt.add(data);
                isInsert = true;
                break;
            }
        }
        if (!isInsert) {
            list.addLast(data);
        }
    }


}
