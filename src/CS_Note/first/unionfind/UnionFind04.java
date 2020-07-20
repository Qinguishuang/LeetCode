package CS_Note.first.unionfind;

import java.util.Arrays;

/**
 * 快速合并
 * 基于高度合并
 */
public class UnionFind04 {
    private int[] id; // 记录顶部节点的位置
    private int[] height; // 记录节点的高度
    private int size;

    public UnionFind04(int size) {
        this.size = size;
        this.id = new int[size];
        this.height = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;
            height[i] = 1;
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
        if (height[f] < height[s]) { // 高度不等时, 合并后高度不变
            id[f] = s;
        } else if (height[f] > height[s]) {
            id[s] = f;
        } else { // 高度相等时, 合并后高度增加
            id[f] = s;
            height[s]++;
        }
    }

    public void printArray() {
        System.out.println(Arrays.toString(this.id));
    }

    public static void main(String[] args) {
        int n = 10;
        UnionFind04 u = new UnionFind04(n);
        u.printArray();

        u.unionElement(2, 5);
        u.printArray();

    }

}
