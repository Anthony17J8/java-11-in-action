package core.generics.genericmeth;

public class GenMethDemo {

    static <T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y) {
        for (int i = 0; i < y.length; i++) {
            if (x.compareTo(y[i]) == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5};
        System.out.println("2 is in nums: " + isIn(2, nums));
        System.out.println("7 is not in nums: " + !isIn(7, nums));

        String[] strs = {"one", "two", "three", "four", "five"};
        System.out.println("two is in strs: " + isIn("two", strs));
        System.out.println("seven is not in strs: " + !isIn("seven", strs));

        // System.out.println("two is in nums: " + isIn("two", nums) );  incompatible types
    }
}
