package core.lambda.methrefwithgeneric;

public class GenericMethodRef {

    static <T> int myOp(MyFunc<T> mf, T[] vals, T v) {
        return mf.func(vals, v);
    }

    public static void main(String[] args) {
        String[] strArr = {"One", "Two", "Three", "Four", "Two"};
        Integer[] iArr = {1, 2, 3, 2, 1, 5, 87, 3, 2};

        System.out.println("string array contains " +
                myOp(MyArrayOps::<String>countMatching, strArr, "Two") +
                " Twos");

        System.out.println("int array contains " +
                myOp(MyArrayOps::<Integer>countMatching, iArr, 2) +
                " 2s");
    }
}

interface MyFunc<T> {
    int func(T[] vals, T v);
}

class MyArrayOps {
    static <T> int countMatching(T[] vals, T v) {
        int count = 0;
        for (T val : vals) {
            if (v.equals(val)) {
                count++;
            }
        }
        return count;
    }
}
