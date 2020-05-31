package core.generics.genericinterface;

public class GenIF {

    public static void main(String[] args) {
        Integer[] iNums = {3, 2, 6, 8, 6};
        Character[] chs = {'a', 'g', 'j', '2'};

        MinMax<Integer> iob = new MinMaxImpl<>(iNums);
        MinMax<Character> cob = new MinMaxImpl<>(chs);

        System.out.println("Max value in inums: " + iob.max());
        System.out.println("Min value in inums: " + iob.min());

        System.out.println("Max value in chs: " + cob.max());
        System.out.println("Min value in chs: " + cob.min());
    }
}

interface MinMax<T extends Comparable<T>> {
    T min();

    T max();
}

class MinMaxImpl<T extends Comparable<T>> implements MinMax<T> {

    T[] vals;

    public MinMaxImpl(T[] vals) {
        this.vals = vals;
    }

    @Override
    public T min() {
        T v = vals[0];
        for (int i = 1; i < vals.length; i++) {
            if (vals[i].compareTo(v) < 0) {
                v = vals[i];
            }
        }
        return v;
    }

    @Override
    public T max() {
        T v = vals[0];
        for (int i = 1; i < vals.length; i++) {
            if (vals[i].compareTo(v) > 0) {
                v = vals[i];
            }
        }
        return v;
    }
}
