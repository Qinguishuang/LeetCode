package book.chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 返回左边和右边小于当前值的最小位置
 */
public class No008 {
    /**
     * 暴力两边查找
     */
    public int[][] rightWay(int[] arr) {
        int[][] ans = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            ans[i][0] = i;
            ans[i][1] = i;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    ans[i][0] = j;
                    break;
                }
            }
            if (ans[i][0] == i) {
                ans[i][0] = -1;
            }
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    ans[i][1] = j;
                    break;
                }
            }
            if (ans[i][1] == i) {
                ans[i][1] = -1;
            }
        }
        return ans;
    }

    /**
     * 不允许重复
     * 维护一个递增的栈
     * 保存坐标, 不保存值
     */
    public int[][] getNearLessNoRepeat(int[] arr) {
        int[][] ans = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            // 如果当前值小于栈顶部的值, 弹出(得到弹出值的结果)
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int pop = stack.pop();
                // 如果栈不为空, 前一个就是小于当前值得位置, 否则-1
                int leftMin = stack.isEmpty() ? -1 : stack.peek();
                ans[pop][0] = leftMin;
                ans[pop][1] = i;
            }
            stack.push(arr[i]);
        }
        // 剩下的元素是递增的, 右边都为-1
        while (!stack.isEmpty()) {
            int pop = stack.pop();
            int leftMin = stack.isEmpty() ? -1 : stack.peek();
            ans[pop][0] = leftMin;
            ans[pop][1] = -1;
        }
        return ans;
    }

    /**
     * 允许有重复时
     * 将重复值放入同一个链表, 最后同时出栈
     */
    public int[][] getNearLess(int[] arr) {
        int[][] ans = new int[arr.length][2];
        Stack<List<Integer>> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek().get(0)] < arr[i]) {
                List<Integer> tmp = stack.pop();
                // 取最晚加入的那个的下标
                // 元素 [3, 1, 3, 4, 3, 5, 3, 2, 2]
                // 栈   {   1,[2,    4,    6]}
                int leftMin = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                for (Integer pop : tmp) {
                    ans[pop][0] = leftMin;
                    ans[pop][1] = i;
                }
            }
            // 现在的和栈顶的那个列表中的元素相等, 就放进去, 否则新建一个链表
            if ((!stack.isEmpty()) && arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(i);
            } else { // 新建一个链表放进去
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }
        // 剩下一个递增的栈
        while (!stack.isEmpty()) {
            List<Integer> popList = stack.pop();
            int leftMin = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            for (Integer pop : popList) {
                ans[pop][0] = leftMin;
                ans[pop][1] = -1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        No008 n = new No008();
        System.out.println(Arrays.deepToString(n.rightWay(new int[]{3, 4, 1, 5, 6, 2, 7})));
    }

}
