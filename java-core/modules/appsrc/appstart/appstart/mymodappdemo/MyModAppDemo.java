package appstart.mymodappdemo;

import appfuncs.simplefuncs.SimpleMathFuncs;
import appsupport.supportfuncs.SupportFuncs;
import userfuncs.binaryfuncs.BinFuncProvider;
import userfuncs.binaryfuncs.BinaryFunc;

import java.util.ServiceLoader;

/**
 * 1. javac -d appmodules/appfuncs appsrc/appfuncs/module-info.java appsrc/appfuncs/appfuncs/simplefuncs/SimpleMathFuncs.java
 * 2. javac --module-path appmodules -d appmodules/appstart appsrc/appstart/module-info.java appsrc/appstart/appstart/mymodappdemo/MyModAppDemo.java
 * 3. java --module-path appmodules -m appstart/appstart.mymodappdemo.MyModAppDemo
 * <p>
 * Multi-module mode:
 * javac -d appmodules --module-source-path appsrc appsrc/appstart/appstart/mymodappdemo/MyModAppDemo.java
 * <p>
 * Module-base Service example:
 * javac -d appmodules --module-source-path appsrc appsrc/userfuncsimp/module-info.java appsrc/appstart/appstart/mymodappdemo/MyModAppDemo.java
 * java --module-path appmodules -m appstart/appstart.mymodappdemo.MyModAppDemo
 */
public class MyModAppDemo {

    public static void main(String[] args) {

        if (SupportFuncs.isFactor(2, 10)) {
            System.out.println("2 is a factor of 10");
        }

        System.out.println("Smallest factor common to both 35 and 105 is " +
                SimpleMathFuncs.lcf(35, 105));

        System.out.println("Largest factor common to both 35 and 105 is " +
                SimpleMathFuncs.gcf(35, 105));

        // using service-based operations

        BinaryFunc binOp = null;
        // get a service loader for binary functions
        ServiceLoader<BinFuncProvider> ldr = ServiceLoader.load(BinFuncProvider.class);

        // finding provider for absPlus function
        for (BinFuncProvider bfp : ldr) {
            if (bfp.get().getName().equals("absPlus")) {
                binOp = bfp.get();
                break;
            }
        }

        if (binOp != null) {
            System.out.println("Result of absPlus function: " + binOp.func(12, -4));
        } else {
            System.out.println("absPlus function not found");
        }

        binOp = null;

        // finding provider for absMinus function
        for (BinFuncProvider bfp : ldr) {
            if (bfp.get().getName().equals("absMinus")) {
                binOp = bfp.get();
                break;
            }
        }

        if (binOp != null) {
            System.out.println("Result of absMinus function: " + binOp.func(12, -4));
        } else {
            System.out.println("absMinus function not found");
        }

    }
}
