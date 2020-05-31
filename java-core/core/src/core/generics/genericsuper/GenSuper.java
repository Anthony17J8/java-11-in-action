package core.generics.genericsuper;

/**
 * In a generic hierarchy, any type arguments needed by a generic superclass must be passed
 * up the hierarchy by all subclasses.
 */
public class GenSuper {
    public static void main(String[] args) {
        Gen2<String, Integer> obj = new Gen2<>("year", 2020);
        System.out.println("Current " + obj.getOb() + " is " + obj.getOb2());
    }
}

class Gen<T> {
    T ob;

    public Gen(T ob) {
        this.ob = ob;
    }

    T getOb() {
        return ob;
    }
}

class Gen2<T, V> extends Gen<T> {
    V ob2;

    Gen2(T ob, V ob2) {
        super(ob);
        this.ob2 = ob2;
    }

    V getOb2() {
        return ob2;
    }
}
