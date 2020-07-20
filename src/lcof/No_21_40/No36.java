package lcof.No_21_40;

public class No36 {
    Node pre = null;
    Node head = null;

    public Node treeToDoublyList(Node root) {
        inOrder(root);
        return root;
    }

    private void inOrder(Node root) {
        if (root == null)
            return;

        inOrder(root.left);

        root.left = pre;
        if (pre != null) {
            pre.right = root;
        }
        pre = root;
        if (head == null) { // 记录头节点，只修改一次
            head = root;
        }

        inOrder(root.right);
    }


    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}

