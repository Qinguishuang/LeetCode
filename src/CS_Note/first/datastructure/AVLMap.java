package CS_Note.first.datastructure;

import java.util.Comparator;

public class AVLMap<K, V> {
    private int size;
    private AVLEntry<K, V> root;
    private Comparator<K> comparator;

    public AVLMap() {
    }

    public AVLMap(Comparator<K> comparator) {
        this.comparator = comparator;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return size == 0;
    }



    @SuppressWarnings("unchecked")
    private int compare(K a, K b) {
        if (comparator == null) {
            Comparable<K> c = (Comparable<K>) a;
            return c.compareTo(b);
        } else {
            return comparator.compare(a, b);
        }
    }
}
