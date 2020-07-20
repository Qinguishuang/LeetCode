package CS_Note.first.swordToOffer.No_21_40;

public class No35 {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;
        RandomListNode root = pHead;
        // 复制节点
        while (root != null) {
            RandomListNode tmp = new RandomListNode(root.label);
            tmp.next = root.next;
            root.next = tmp;
            root = tmp.next;
        }
        // 复制指针
        root = pHead;
        while (root != null) {
            if (root.random != null)
                root.next.random = root.random.next;
            root = root.next.next;
        }
        // 拆分
        RandomListNode dummyNode = new RandomListNode(0);
        RandomListNode dummyHead = dummyNode;
        root = pHead;
        while (root != null) {
            dummyNode.next = root.next;
            root.next = root.next.next;

            root = root.next;
            dummyNode = dummyNode.next;
        }
        return dummyHead.next;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}