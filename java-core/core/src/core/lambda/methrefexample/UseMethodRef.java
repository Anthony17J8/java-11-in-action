package core.lambda.methrefexample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UseMethodRef {
    static int compare(MyClass mc1, MyClass mc2) {
        return mc1.getVal() - mc2.getVal();
    }

    public static void main(String[] args) {
        List<MyClass> list = new ArrayList<>();
        list.add(new MyClass(1));
        list.add(new MyClass(-3));
        list.add(new MyClass(5));
        list.add(new MyClass(4));
        list.add(new MyClass(0));
        list.add(new MyClass(5));

        System.out.println("Max value of list: " + Collections.max(list, UseMethodRef::compare).getVal());
    }
}

class MyClass {

    private int val;

    public MyClass(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}
