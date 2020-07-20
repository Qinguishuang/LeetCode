package book.chapter1;

public class No006 {
    public static void hanoi(int n, int from, int to, int mid) {
        if (n == 1) {
            System.out.println(from + " -> " + to);
            return;
        }
        hanoi(n - 1, from, mid, to);
        hanoi(1, from, to, mid);
        hanoi(n - 1, mid, to, from);
    }

    public static void main(String[] args) {
        hanoi2(2, 1, 2, 3, 1, 3);
    }

    public static void hanoi2(int n, int left, int mid, int right, int from, int to) {
        if (n == 1) {
            if (from == 2 || to == 2) {
                System.out.println(from + " -> " + to);
                return;
            } else {
                System.out.println(from + " -> " + mid);
                System.out.println(mid + " -> " + to);
                return;
            }
        }
        if (from == 2 || to == 2) {
            int another = (from == 1 || to == 1) ? 3 : 1;
            hanoi2(n - 1, 1, 2, 3, from, another);
            hanoi2(n - 1, 1, 2, 3, another, to);
        } else {
            hanoi2(n - 1, 1, 2, 3, from, to);
            hanoi2(n - 1, 1, 2, 3, to, from);
            hanoi2(n - 1, 1, 2, 3, from, to);
        }
    }
}
