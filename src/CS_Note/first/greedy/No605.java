package CS_Note.first.greedy;

public class No605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length < 1)
            return false;
        int[] flower = new int[flowerbed.length + 2];
        System.arraycopy(flowerbed, 0, flower, 1, flowerbed.length);
        for (int i = 1; i < flower.length - 1; i++) {
            if (flower[i] == 0 && flower[i - 1] == 0 && flower[i + 1] == 0) {
                flower[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }
}
