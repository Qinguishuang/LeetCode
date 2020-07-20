package CS_Note.first.bst;

import java.util.ArrayList;
import java.util.List;

public class BST<Key extends Comparable<Key>, Value> implements OrderedST<Key, Value> {
    protected Node root;

    protected class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int N;
        boolean color;

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            N = n;
        }
    }

    @Override
    public int size() {
        return size(root);
    }

    public int size(Node x) {
        if (x == null)
            return 0;
        return x.N;
    }

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    public Node put(Node x, Key key, Value value) {
        if (x == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            x.value = value;
        } else if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else {
            x.right = put(x.right, key, value);
        }
        recalculateSize(x);
        return x;
    }

    @Override
    public Value get(Key key) {
        return get(root, key);
    }

    public Value get(Node x, Key key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x.value;
        } else if (cmp < 0) {
            return get(x.left, key);
        } else {
            return get(x.right, key);
        }
    }

    protected void recalculateSize(Node x) {
        x.N = size(x.left) + size(x.right) + 1;
    }

    @Override
    public Key min() {
        return min(root).key;
    }

    private Node min(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root;
        }
        return min(root.left);
    }

    @Override
    public Key max() {
        return null;
    }

    @Override
    public int rank(Key key) {
        return 0;
    }

    @Override
    public List<Key> keys(Key l, Key h) {
        return keys(root, l, h);
    }

    private List<Key> keys(Node root, Key l, Key r) {
        List<Key> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        int cmpL = l.compareTo(root.key);
        int cmpR = r.compareTo(root.key);
        if (cmpL < 0) {
            list.addAll(keys(root.left, l, r));
        }
        if (cmpL <= 0 && cmpR >= 0) {
            list.add(root.key);
        }
        if (cmpL > 0) {
            list.addAll(keys(root.right, l, r));
        }
        return list;
    }

    /**
     * 小于key的最大值
     */
    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        }
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        } else if (cmp < 0) {
            return floor(x.left, key);
        }
        Node t = floor(x.right, key);
        return t != null ? t : x;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node root) {
        if (root.left == null) {
            return root.right;
        }
        root.left = deleteMin(root.left);
        recalculateSize(root);
        return root;
    }

    public void delete(Key key) {

    }

    /**
     * 如果待删除节点只有一个子树, 直接让待删除节点的链接指向唯一的子节点
     * 否则, 找到右子树的最小节点替换该节点
     */
    public Node delete(Node root, Key key) {
        if (root == null) {
            return null;
        }
        int cmp = key.compareTo(root.key);
        if (cmp < 0) {
            root.left = delete(root.left, key);
        } else if (cmp > 0) {
            root.right = delete(root.right, key);
        } else {
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
            Node t = root;
            root = min(root.right); // 获取右节点的最小节点
            root.right = deleteMin(t.right);
            root.left = t.left;
        }
        recalculateSize(root);
        return root;
    }


}
