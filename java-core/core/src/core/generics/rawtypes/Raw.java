package core.generics.rawtypes;

public class Raw {

    public static void main(String[] args) {
        Gen<Integer> iOb = new Gen<>(88);
        Gen<String> sOb = new Gen<>("Raw Types Example");
        Gen raw = new Gen(Double.valueOf(1.0));

        double d = (Double) raw.getObj();
        System.out.println("Value of raw: " + d);

        sOb = raw;
        // String obj = sOb.getObj(); run-time error

        raw = iOb;
        // d = (Double) raw.getObj(); run-time error
    }
}

class Gen<T> {
    T ob;

    public Gen(T ob) {
        this.ob = ob;
    }

    public T getObj() {
        return ob;
    }
}
