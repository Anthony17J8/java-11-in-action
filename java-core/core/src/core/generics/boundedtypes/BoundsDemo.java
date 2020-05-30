package core.generics.boundedtypes;

public class BoundsDemo {

    public static void main(String[] args) {
        Integer[] iNums = {1, 2, 3, 4, 5};
        Stats<Integer> iob = new Stats<>(iNums);
        System.out.println("iob average is: " + iob.average());

        Double[] dNums = {1.1, 2.2, 3.3, 4.4, 5.5};
        Stats<Double> dob = new Stats<>(dNums);
        System.out.println("dob average is: " + dob.average());

        Float[] fNums = {1.0F, 2.0F, 3.0F, 4.0F, 5.0F};
        Stats<Float> fob = new Stats<>(fNums);
        System.out.println("fob average is: " + fob.average());

        System.out.print("Averages of iob and dob ");
        if (iob.sameAvg(dob)) {
            System.out.println("are the same");
        } else {
            System.out.println("differ");
        }

        System.out.print("Averages of iob and fob ");
        if (iob.sameAvg(fob)) {
            System.out.println("are the same");
        } else {
            System.out.println("differ");
        }

        // won't compile because String is not a subclass of Number
        /*String[] sNums = {"1", "2", "3", "4", "5"};
        Stats<String> sob = new Stats<>(sNums);
        System.out.println("sob average is: " + sob.average());*/
    }
}

class Stats<T extends Number> {
    T[] nums;

    public Stats(T[] nums) {
        this.nums = nums;
    }

    double average() {
        double sum = 0.0;

        for (T num : nums) {
            sum += num.doubleValue();
        }

        return sum / nums.length;
    }

    boolean sameAvg(Stats<?> obj) {
        if (average() == obj.average()) {
            return true;
        }
        return false;
    }
}
