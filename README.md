#Java Core

###Description   
The project contains some notes and code examples from books [Java: The Complete Reference, Eleventh Edition](https://www.amazon.com/Java-Complete-Reference-Eleventh/dp/1260440230) and [Core Java, Volume II--Advanced Features (11th Edition)](https://www.amazon.com/Core-Java-II-Advanced-Features-11th/dp/0135166314/ref=pd_sbs_14_5/138-0457775-1001605?_encoding=UTF8&pd_rd_i=0135166314&pd_rd_r=ed53e0eb-2170-4f23-994f-c1b5212b9981&pd_rd_w=eQY4W&pd_rd_wg=TZWfi&pf_rd_p=12b8d3e2-e203-4b23-a8bc-68a7d2806477&pf_rd_r=WMDX49W3X9V9C086K0BQ&psc=1&refRID=WMDX49W3X9V9C086K0BQ) to upgrade to Java 11 and to pass exam 1Z0-817.
 
###Contents
- [Generics](#generics)

## Generics  
- Ambiguity errors that involve overloading methods:

```java
class MyGenClass<T, V> {
    T ob1;
    V ob2;

    void set(T o) {
        ob1 = o;
    }

    void set(V o) {
        ob2 = o;
    }   
}
// these two overloaded methods are ambiguous and won't compile
// because type erasure results in both to 
// void set(Object o) {} 
```
- Type parameter cannot be instantiated:
```java
class Gen<T> {
    T ob;
    
    Gen() {
        ob = new T(); // Illegal!
    }   
}   
```
- A generic class cannot extend **Throwable**. It is not possible
to create generic exception classes.
- Generic types can't be used by static members of classes:
```java
class Wrong<T> {
    // no static variables of type T
    static T ob; 
    
    // no static methods that use T
    static T getOb() {
        return ob;
    }   
}
```
- You cannot create array of type T:
```java
...
T[] vals = new T[10]; // incorrect
```
- You cannot create array of type-specific generic references:
```java
MyClass<Integer> arr[] = new MyClass<Integer>[5]; // incorrect
``` 
but this OK:
```java
MyClass<?> gens[] = new MyClass<?>[10];
```