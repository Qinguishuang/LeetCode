package CS_Note.first.unionfind;

import java.util.Arrays;

/**
 * 数组实现基本操作
 */
public class UnionFind01 {
    private int[] id;
    private int size;

    public UnionFind01(int size) {
        this.size = size;
        this.id = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
    }

    private int find(int element) {
        return id[element];
    }

    public boolean isConnected(int i, int j) {
        return find(i) == find(j);
    }

    public void unionElement(int i, int j) {
        int f = find(i);
        int s = find(j);
        if (f == s) {
            for (int k = 0; k < size; k++) {  // 遍历修改
                if (id[k] == f) {
                    id[k] = s;
                }
            }
        }
    }

    public void printArray() {
        System.out.println(Arrays.toString(this.id));
    }

    public static void main(String[] args) {
        int n = 10;
        UnionFind01 u = new UnionFind01(n);
        u.printArray();

        u.unionElement(2, 5);
        u.printArray();

    }

}
