package book.chapter1;

import java.util.Stack;

/**
 * 可见的山峰对数量
 */
public class No011 {

    public static void main(String[] args) {
        No011 n = new No011();
        System.out.println(n.getVisibleNumStack(new int[]{2, 4, 5, 3, 4, 5, 2, 3, 5, 4, 4}));
    }

    /**
     * 除最大值, 次大值之外
     * 每个山峰两边分别能找到一个比当前值高的
     * 最大值能看到次大值
     * (i - 2) * 2 + 1
     */
    public int getVisibleNum(int[] arr) {
        return (arr.length - 2) * 2 + 1;
    }

    /**
     * 用最小栈
     */
    public int getVisibleNumStack(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        // 统计最小栈
        int size = arr.length;
        int maxIndex = 0;
        // 找到最大值的位置
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        // 从最大值的位置开始, 入栈
        Stack<Record> stack = new Stack<>();
        stack.push(new Record(arr[maxIndex])); // 放入最大值
        // 逆时针遍历
        int index = nextIndex(maxIndex, size);
        int res = 0; // 记录数量
        while (index != maxIndex) {
            // 判断当前值是否比栈顶元素小, 不满足最小栈
            while (stack.peek().getValue() < arr[index]) {
                int k = stack.pop().getTimes();
                res += getNum(k) + 2 * k;
            }
            // 两个相等, 数量增加
            if (stack.peek().getValue() == arr[index]) {
                int num = stack.peek().getTimes();
                stack.peek().setTimes(num + 1);
            } else {
                // 满足最小栈, 加入新元素
                stack.push(new Record(arr[index]));
            }
            // 换下一个元素
            index = nextIndex(index, size);
        }
        // 处理剩下的元素
        while (stack.size() > 2) {
            int times = stack.pop().getTimes();
            res += getNum(times) * 2 * times;
        }
        if (stack.size() == 2) {
            int times = stack.pop().getTimes();
            // 如果剩下的那个元素数量大于1 (2 * times + C(2, times))
            // 剩下的那个元素数量等于1 (1 * times + C(2, times))
            res += getNum(times) + (stack.peek().getTimes() == 1 ? times : 2 * times);
        }
        res += getNum(stack.pop().getTimes());
        return res;
    }

    public int nextIndex(int i, int size) {
        return i < (size - 1) ? (i + 1) : 0;
    }

    public int getNum(int k) {
        return k == 1 ? 0 : (k * (k - 1)) / 2;
    }
}


class Record {
    private int value;
    private int times;

    public Record(int value) {
        this.value = value;
        this.times = 1;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    @Override
    public String toString() {
        return "Record{" +
                "value=" + value +
                ", times=" + times +
                '}';
    }
}