package com.forward.places;

import com.forward.util.ObjectAnalyzer;

/**
 * 1.Compile util module
 * javac com.forward.util/src/module-info.java \
 * > com.forward.util/src/com/forward/util/ObjectAnalyzer.java
 * <p>
 * 2.Compile current module
 * javac -p com.forward.util/src com.forward.hello/src/module-info.java com.forward.hello/src/com/forward/places/*.java
 * <p>
 * 3. Run Demo class
 * java -p com.forward.util:com.forward.hello -m com.forward.hello/com.forward.places.Demo
 */
public class Demo {

    /*
        module com.forward.hello does not "opens com.forward.places" to module com.forward.util
        To solve this: open package or open the whole module
     */
    public static void main(String[] args) throws ReflectiveOperationException {
        var russia = new Country("Russia", 22552);
        var analyzer = new ObjectAnalyzer();
        System.out.println(analyzer.toString(russia));
    }
}
