package CS_Note.first.unionfind;

import java.util.Arrays;

/**
 * 快速合并, 建立树形
 */
public class UnionFind02 {
    private int[] id;
    private int size;

    public UnionFind02(int size) {
        this.size = size;
        this.id = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
    }

    private int find(int element) {
        while (element != id[element]) { // 循环到最上层
            element = id[element];
        }
        return element;
    }

    public boolean isConnected(int i, int j) {
        return find(i) == find(j);
    }

    /**
     * 合并两个分组
     */
    public void unionElement(int i, int j) {
        int f = find(i);
        int s = find(j);
        if (f == s) {
            return;
        }
        id[f] = s; // 只修改顶部节点的值
    }

    public void printArray() {
        System.out.println(Arrays.toString(this.id));
    }

    public static void main(String[] args) {
        int n = 10;
        UnionFind02 u = new UnionFind02(n);
        u.printArray();

        u.unionElement(2, 5);
        u.printArray();

    }

}
