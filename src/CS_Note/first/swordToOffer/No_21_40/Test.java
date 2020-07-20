package CS_Note.first.swordToOffer.No_21_40;

public class Test {
    public static void main(String[] args) {
        No35 n = new No35();
        RandomListNode r = new RandomListNode(1);
        r.next = new RandomListNode(2);
        // r.next.next = new RandomListNode(3);

        n.Clone(r);
    }
}
