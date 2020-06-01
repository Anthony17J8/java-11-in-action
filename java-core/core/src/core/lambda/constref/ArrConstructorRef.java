package core.lambda.constref;

/**
 * functional interface must contain a method that takes a single int parameter
 * if it is to be used to refer to an array constructor.
 */
public class ArrConstructorRef {

    public static void main(String[] args) {
        MyArrayCreator<ArrClass[]> mac = ArrClass[]::new;
        ArrClass[] arr = mac.func(3);
        arr[0] = new ArrClass(1);
        arr[1] = new ArrClass(2);
        arr[2] = new ArrClass(3);
    }

}

interface MyArrayCreator<T> {
    T func(int num);
}

class ArrClass {
    private int value;

    public ArrClass(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
