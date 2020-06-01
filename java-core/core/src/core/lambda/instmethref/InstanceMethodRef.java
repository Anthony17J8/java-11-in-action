package core.lambda.instmethref;

/**
 * objRef::methodName
 */
public class InstanceMethodRef {

    static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String str = "Instance Method Reference";
        MyStringOps mso = new MyStringOps();
        System.out.println(stringOp(mso::strReverse, str));
    }
}

interface StringFunc {
    String func(String n);
}

class MyStringOps {
    String strReverse(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
}
