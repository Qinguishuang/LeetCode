package CS_Note.first.unionfind;

import java.util.Arrays;

/**
 * 快速合并
 * 基于节点数量合并
 */
public class UnionFind03 {
    private int[] id;
    private int[] weight; // 记录节点上的数量
    private int size;

    public UnionFind03(int size) {
        this.size = size;
        this.id = new int[size];
        this.weight = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;
            weight[i] = 1;
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
        if (f == s) { // 顶部节点相等, 不需要合并
            return;
        }
        if (weight[f] > weight[s]) { // 判断哪个节点多, 多的作为顶部节点
            id[s] = f;
            weight[f] += weight[s];
        } else {
            id[f] = s;
            weight[s] += weight[f];
        }
    }

    public void printArray() {
        System.out.println(Arrays.toString(this.id));
    }

    public static void main(String[] args) {
        int n = 10;
        UnionFind03 u = new UnionFind03(n);
        u.printArray();

        u.unionElement(2, 5);
        u.printArray();

    }

}
