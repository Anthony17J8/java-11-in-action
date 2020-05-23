package appstart.mymodappdemo;

import appfuncs.simplefuncs.SimpleMathFuncs;

/**
 * 1. javac -d appmodules/appfuncs appsrc/appfuncs/module-info.java appsrc/appfuncs/appfuncs/simplefuncs/SimpleMathFuncs.java
 * 2. javac --module-path appmodules -d appmodules/appstart appsrc/appstart/module-info.java appsrc/appstart/appstart/mymodappdemo/MyModAppDemo.java
 * 3. java --module-path appmodules -m appstart/appstart.mymodappdemo.MyModAppDemo
 */
public class MyModAppDemo {

    public static void main(String[] args) {

        if (SimpleMathFuncs.isFactor(2, 10)) {
            System.out.println("2 is a factor of 10");
        }

        System.out.println("Smallest factor common to both 35 and 105 is " +
                SimpleMathFuncs.lcf(35, 105));

        System.out.println("Largest factor common to both 35 and 105 is " +
                SimpleMathFuncs.gcf(35, 105));
    }
}
