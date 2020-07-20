package CS_Note.first.backtracking;

import java.util.LinkedList;

public class EightQueenTest {

    private static int SIZE = 4;
    private static LinkedList<Location> ans = new LinkedList<>();

    public static void main(String[] args) {
        eightQueen(0, 0);
    }

    public static void eightQueen(int r, int c) {
        if (ans.size() == SIZE) {
            printList();
            return;
        }

        for (int i = r; i < SIZE; i++) {
            Location location = new Location(i, c);
            if (isLegal(i, c)) {
                ans.add(location);
                eightQueen(0, c + 1);
                ans.poll();
            }
        }
    }

    public static boolean isLegal(int r, int c) {
        for (Location loc : ans) {
            if (loc.x == r || loc.y == c) {
                return false;
            } else if (Math.abs(loc.x - r) == Math.abs(loc.y - c)) {
                return false;
            }
        }
        return true;
    }

    static class Location {
        private int x;
        private int y;

        public Location() {
        }

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")\t";
        }
    }

    public static void printList() {
        System.out.println(ans.toString());
    }

}
