package core.generics.genericcons;

public class GenCons {

    private double val;

    public <T extends Number> GenCons(T val) {
        this.val = val.doubleValue();
    }

    void showVal() {
        System.out.println("val: " + val);
    }

    public static void main(String[] args) {
        GenCons iob = new GenCons(120);
        iob.showVal();

        GenCons fob = new GenCons(120F);
        fob.showVal();

        GenCons sob = new GenCons((short) 123);
        sob.showVal();
    }
}
