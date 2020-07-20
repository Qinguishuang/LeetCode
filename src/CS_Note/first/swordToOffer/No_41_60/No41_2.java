package CS_Note.first.swordToOffer.No_41_60;

import java.util.LinkedList;
import java.util.Queue;

public class No41_2 {
    /**
     * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
     * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
     */

    char[] c = new char[256];
    Queue<Character> q = new LinkedList<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        c[ch]++;
        q.add(ch);
        if (!q.isEmpty() && c[q.peek()] > 1) {
            q.poll();
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        return q.isEmpty() ? '#' : q.peek();
    }
}
