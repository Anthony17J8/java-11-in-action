package core.lambda.constref;

public class ConstructorRef {

    public static void main(String[] args) {
        MyFunc mf = MyClass::new;
        MyClass mc = mf.func(100);
        System.out.println(mc.getVal());
    }
}

interface MyFunc {
    MyClass func(int i);
}

class MyClass {
    private int val;

    public MyClass(int val) {
        this.val = val;
    }

    public MyClass() {
        this.val = 0;
    }

    public int getVal() {
        return val;
    }
}
