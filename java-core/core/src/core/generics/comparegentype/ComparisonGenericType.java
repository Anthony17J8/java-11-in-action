package core.generics.comparegentype;

public class ComparisonGenericType {

    public static void main(String[] args) {
        Gen<Integer> iOb = new Gen<>(88);
        Gen2<Integer> iOb2 = new Gen2<>(99);
        Gen2<String> sOb = new Gen2<>("Test");

        if (iOb2 instanceof Gen2<?>) {
            System.out.println("iob2 is instance of Gen2");
        }

        if (iOb2 instanceof Gen<?>) {
            System.out.println("iob2 is instance of Gen");
        }

        System.out.println();

        if (sOb instanceof Gen2<?>) {
            System.out.println("sOb is instance of Gen2");
        }

        if (sOb instanceof Gen<?>) {
            System.out.println("sOb is instance of Gen");
        }

        System.out.println();

        if (iOb instanceof Gen2<?>) {
            System.out.println("iob is instance of Gen2");
        }

        if (iOb instanceof Gen<?>) {
            System.out.println("iob is instance of Gen");
        }

        // generic type info does not exist at runtime
        /*if(iOb2 instanceof Gen2<Integer>) {
            System.out.println("iOb2 is instance of Gen2<Integer>");
        }*/
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

class Gen2<T> extends Gen<T> {

    Gen2(T ob) {
        super(ob);
    }
}