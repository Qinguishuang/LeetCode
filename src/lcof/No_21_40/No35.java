package lcof.No_21_40;

public class No35 {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node dummyNode = new Node(0);
        dummyNode.next = head;
        // 先next完成复制
        while (head != null) {
            Node tmp = new Node(head.val);
            tmp.next = head.next;
            head.next = tmp;
            head = tmp.next;
        }
        // 完成random复制
        head = dummyNode.next;
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
        // 拆分
        head = dummyNode.next;
        Node newHead = dummyNode;
        while (head != null) {
            newHead.next = head.next;
            head.next = head.next.next;

            newHead = newHead.next;
            head = newHead.next;
        }
        return dummyNode.next;

    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}

