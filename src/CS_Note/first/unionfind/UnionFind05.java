package CS_Note.first.unionfind;

/**
 * 路径压缩(让当前节点指向父亲的父亲)
 * 只能在基于重量的并查集总使用
 * 压缩后根的重量不变, 高度变化
 */
public class UnionFind05 {
    private int[] parent;
    private int[] weight;
    private int size;

    public UnionFind05(int size) {
        this.parent = new int[size];
        this.weight = new int[size];
        this.size = size;
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            weight[i] = 1;
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
        if (weight[f] == weight[s]) {
            parent[s] = f;
            weight[f] += weight[s];
        } else {
            parent[f] = s;
            weight[s] += weight[f];
        }
    }
}
