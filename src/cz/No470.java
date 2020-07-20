package cz;

import java.util.Random;

public class No470 {
    public int rand10() {
        // rand7 -> 1 - 7
        // (0 - 6) * 7 -> {0, 7, 14, 21, 28, 35, 42}
        // + rand7 -> {0 - 49} 均匀
        int num = (rand7() - 1) * 7 + rand7(); // 随机生成 1 - 49
        while (num > 10) {
            num = (rand7() - 1) * 7 + rand7();
        }
        return num;
    }

    public int rand7() {
        return new Random().nextInt(8);
    }
}
