package CS_Note.first.unionfind;

import java.util.Scanner;

/**
 * N个人要坐在桌子上吃饭，但是人们拒绝和陌生人坐在一张桌子上。
 * 什么样的不算陌生人呢？主要是朋友的朋友的朋友的.....只要能扯上关系就不算陌生人。
 * 能扯上关系就可以坐在一张桌子上。所以至少要准备多少张桌子？
 */
public class UnionFindTest01 {
    private int[] parent;
    private int[] weight;
    private int size;
    private int groups;

    public UnionFindTest01(int size) {
        this.parent = new int[size];
        this.weight = new int[size];
        this.size = size;
        this.groups = size; // 首先每人一个分组
        for (int i = 0; i < size; i++) {
            this.parent[i] = i;
            this.weight[i] = 1;
        }
    }

    public int find(int e) {
        while (e != parent[e]) {
            parent[e] = parent[parent[e]];
            e = parent[e];
        }
        return e;
    }

    public boolean isConnected(int f, int s) {
        return find(f) == find(s);
    }

    public void unionElements(int fe, int se) {
        int f = find(fe);
        int s = find(se);
        if (f == s)
            return;
        if (weight[f] > weight[s]) {
            parent[s] = f;
            weight[f] += weight[s];
        } else {
            parent[f] = s;
            weight[s] += weight[f];
        }
        groups--; // 合并之后, 少了一组
    }

    public int getGroups() {
        return groups;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        for (int i = 0; i < times; i++) {
            int size = sc.nextInt();
            UnionFindTest01 u = new UnionFindTest01(size);
            for (int j = 0; j < size; j++) {
                int f = sc.nextInt() - 1;
                int s = sc.nextInt() - 1;
                u.unionElements(f, s);
            }
            System.out.println(u.getGroups());
        }
    }
}
