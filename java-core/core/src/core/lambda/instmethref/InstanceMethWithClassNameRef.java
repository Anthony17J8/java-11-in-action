package core.lambda.instmethref;

/**
 *  ClassName::instanceMethodName
 */
public class InstanceMethWithClassNameRef {

    static <T> int counter(T[] vals, MyFunc<T> mf, T target) {
        int count = 0;
        for (T val : vals) {
            if (mf.func(val, target)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        HighTemp[] htArr = {
                new HighTemp(89), new HighTemp(82),
                new HighTemp(91), new HighTemp(85),
                new HighTemp(89), new HighTemp(90),
                new HighTemp(87), new HighTemp(93),
        };

        System.out.println(
                counter(htArr, HighTemp::sameTemp, new HighTemp(89))
                        + " days that had a temperature of 89");

        System.out.println(
                counter(htArr, HighTemp::lessThanTemp, new HighTemp(86))
                        + " days that had a temperature less than 86"
        );
    }
}

/**
 * First argument is a type of invoking object
 * Second argument is a type of method parameter
 */
interface MyFunc<T> {
    boolean func(T v1, T v2);
}

class HighTemp {
    private int hTemp;

    public HighTemp(int hTemp) {
        this.hTemp = hTemp;
    }

    boolean sameTemp(HighTemp ht2) {
        return this.hTemp == ht2.hTemp;
    }

    boolean lessThanTemp(HighTemp ht2) {
        return this.hTemp < ht2.hTemp;
    }
}
