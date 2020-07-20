package nowcoder.guazi2019;

import linkedlist.ListNode;
import tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main01_1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] tmp = s.split(" ");
        StringBuffer ans = new StringBuffer();
        for (int i = ans.length() - 1; i >= 0; i--) {
            ans.append(tmp[i]).append(" ");
        }
        System.out.println(ans.toString().trim());
    }

    public static void main01_2(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuffer ans = new StringBuffer(s).reverse();
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            if (ans.charAt(i) == ' ' || i == s.length() - 1) {
                myReverse(start, end, ans);
                start = end + 1;
                end = end + 1;
            }
        }
        System.out.println(ans.toString());
    }

    public static void myReverse(int start, int end, StringBuffer s) {
        while (start < end) {
            char tmp = s.charAt(start);
            s.setCharAt(start, s.charAt(end));
            s.setCharAt(end, tmp);
            start++;
            end--;
        }
    }

    public static void main02_1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[5][n + 1];
        int[] coins = new int[]{1, 2, 5, 10};
        dp[0][0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; j - k * coins[i - 1] >= 0; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - k * coins[i - 1]]) % 1000000007;
                }
            }
        }
        System.out.println(dp[4][n]);
    }

    public static void main02_2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[5][n + 1];
        int[] coins = new int[]{1, 2, 5, 10};
        dp[0][0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] = (dp[i][j] + dp[i][j - coins[i - 1]]) % 1000000007;
                }
            }
        }
        System.out.println(dp[4][n]);
    }

    public static void main02_3(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        int[] coins = new int[]{1, 2, 5, 10};
        dp[0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= n; j++) {
                if (j - coins[i - 1] >= 0) {
                    dp[j] = (dp[j] + dp[j - coins[i - 1]]) % 1000000007;
                }
            }
        }
        System.out.println(dp[n]);
    }

    public static void main03(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nums = sc.nextInt();
        String[] input = new String[nums];
        for (int i = 0; i < nums; i++) {
            input[i] = sc.nextLine();
        }
    }

    /**
     * 异或两次 变回原值
     */
    public static void main03_2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // 获取数字后, 还有一个换行符, 消耗掉
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuffer.append(sc.nextLine());
        }
        if (n == 1) {
            System.out.println(stringBuffer.substring(1, 2) + stringBuffer.substring(0, 1));
            return;
        }
        char[] array = stringBuffer.toString().toCharArray();
        StringBuilder sBuffer = new StringBuilder();
        int len = array.length / n; // 计算字符串的长度
        for (int i = 0; i < len; i++) { // 每次计算一位
            char tmp = 0;
            for (int j = i; j < array.length; j += len) {
                tmp ^= array[j];
            }
            sBuffer.append(tmp);
        }
        System.out.println(sBuffer.toString());
    }

    public static void main04(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 第一棵树的节点个数
        int m = sc.nextInt(); // 第二颗树的节点个数
        int[] tree1 = new int[n * 3];
        int[] tree2 = new int[n * 3];
        for (int i = 0; i < tree1.length; i++) {
            tree1[i] = sc.nextInt();
        }
        for (int i = 0; i < tree2.length; i++) {
            tree2[i] = sc.nextInt();
        }
        TreeNode t1 = buildTree(tree1);
        TreeNode t2 = buildTree(tree2);

        TreeNode root = mergeTree(t1, t2);

        List<Integer> ans = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode tmp = q.poll();
                ans.add(tmp.val);
                if (tmp.left != null)
                    q.add(tmp.left);
                if (tmp.right != null)
                    q.add(tmp.right);
            }
        }
        for (Integer an : ans) {
            System.out.printf(an + " ");
        }
        System.out.println();
    }

    private static TreeNode mergeTree(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTree(t1.left, t2.left);
        root.right = mergeTree(t1.right, t2.right);
        return root;
    }

    private static TreeNode buildTree(int[] tree) {
        TreeNode head = new TreeNode(0);
        // 节点编号, 节点
        Map<Integer, TreeNode> tmp = new HashMap<>();
        TreeNode root = head;
        for (int i = 0, layer = 1; i < tree.length; i += 3, layer++) {
            int left = tree[i];
            int right = tree[i + 1];
            int val = tree[i + 2];

            if (tmp.containsKey(layer)) {
                root = tmp.get(layer);
            }

            root.val = val;

            if (left == 0)
                root.left = null;
            else {
                root.left = new TreeNode(0);
                tmp.put(left, root.left);
            }
            if (right == 0)
                root.right = null;
            else {
                root.right = new TreeNode(0);
                tmp.put(right, root.right);
            }
        }
        return head;
    }

    /**
     * 找到可蓄水的地方
     * 找出左右两侧的最高点, 较低的作为蓄水高度
     */
    public static void main05(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] water = new int[n];
        for (int i = 0; i < n; i++) {
            water[i] = sc.nextInt();
        }
        int[] left = new int[n];
        int[] right = new int[n];
        int max = 0;
        // 计算出该点左侧最大值
        for (int i = 0; i < n; i++) {
            max = Math.max(water[i], max);
            left[i] = max;
        }
        max = 0;
        // 计算出所有点右侧的最大值
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, water[i]);
            right[i] = max;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int small = Math.min(left[i], right[i]);
            ans += (small - water[i]);
        }
        System.out.println(ans);
    }

    public static void main06(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        if (nums.length < 3) {
            System.out.println(false);
            return;
        }
        int min = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) {
                min = nums[i];
            } else if (nums[i] <= mid) {
                mid = nums[i];
            } else {
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);
    }

    public static List<Integer> preOrder(TreeNode root) {
        if (root == null)
            return null;
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        while (root != null || !s.isEmpty()) {
            if (root != null) {
                s.push(root);
                ans.add(root.val);
                root = root.left;
            } else {
                TreeNode tmp = s.pop();
                root = tmp.right;
            }
        }
        return ans;
    }

    public static List<Integer> inOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        while (root != null || !s.isEmpty()) {
            if (root != null) {
                s.push(root);
                root = root.left;
            } else {
                TreeNode tmp = s.pop();
                ans.add(tmp.val);
                root = tmp.right;
            }
        }
        return ans;
    }

    public static List<Integer> postOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> s = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        TreeNode pre = null;
        while (root != null || !s.isEmpty()) {
            if (root != null) {
                s.push(root);
                root = root.left;
            } else {
                TreeNode tmp = s.peek();
                if (tmp.right == null || tmp.right == pre) {
                    ans.add(s.pop().val);
                    pre = tmp;
                } else {
                    root = tmp.right;
                }
            }
        }
        return ans;
    }

    public static List<Integer> levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode tmp = q.poll();
                ans.add(tmp.val);
                if (tmp.left != null)
                    q.add(tmp.left);
                if (tmp.right != null)
                    q.add(tmp.right);
            }
        }
        return ans;
    }

    public static void main09(String[] args) {
        Scanner sc = new Scanner(System.in);
        String m = sc.nextLine();
        String n = sc.nextLine();
        int[][] dp = new int[m.length() + 1][n.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (m.charAt(i - 1) == n.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]) + 1;
                }
            }
        }
        System.out.println(dp[dp.length - 1][dp[0].length - 1]);
    }

    public static ListNode main11(ListNode head) {
        if (head == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                slow = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }

    public static ListNode main14(ListNode root) {
        if (root == null)
            return null;
        ListNode pre = null;
        ListNode curr = root;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static void main15(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] isVisited = new boolean[n][n];
        int ans = 0;
        ArrayList tmp = new ArrayList();
        backTracing(isVisited, 0, 0, ans, tmp);
    }

    private static void backTracing(boolean[][] isVisited, int i, int j, int ans, ArrayList tmp) {
        if (tmp.size() == isVisited.length) {
            ans ++;
        } else {
            for (int k = i; k < isVisited.length; k++) {
                for (int l = j; l < isVisited[0].length; l++) {
                    if (!isVisited[k][l]) {
                        // tmp.add(ans[k][l]);
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        main09(args);
    }
}
