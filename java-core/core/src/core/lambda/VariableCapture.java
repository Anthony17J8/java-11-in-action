package core.lambda;

public class VariableCapture {

    public static void main(String[] args) {
        // local variable that can be captured
        int num = 10;

        MyFunc myFunc = (n) -> {
            int v = num + n;

            // we can't modify
            // num++;
            return v;
        };
        // attempt to change num remove effectively final status of it
        // num = 9;
    }
}

interface MyFunc {
    int func(int n);
}
