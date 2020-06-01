package core.lambda.methstaticref;

public class StaticMethodRef {

    static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String str = "Static Method Reference";
        System.out.println(stringOp(MyStringOps::strReverse, str));
    }
}

interface StringFunc {
    String func(String n);
}

class MyStringOps {
    static String strReverse(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
}
