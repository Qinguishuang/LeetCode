package CS_Note.first.search;

import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        No127 n = new No127();
        List<String> list = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        int i = n.ladderLength("hit", "cog", list);
        System.out.println(i);
    }


}
