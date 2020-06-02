# Java Core

### Description   
The project contains some notes and code examples to upgrade to Java 11 and to pass exam 1Z0-817.
 
### Contents
- [Generics](#generics)
- [Lambda Expressions](#lambda-expressions)
- [Collections](#collections)

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

## Lambda Expressions
- Lambda expression has access to instance and static members defined by enclosing class
- Lambda expression has access to local variable and can use it, as for as this variable is _effectively final_. So 
neither inside lambda expression or outside this variable must not be modified, otherwise
code won't compile    

## Collections
![Collection Hierarchy](https://dzone.com/storage/temp/1821372-class-and-interface-hierarchy.png)
The **capacity** is the number of buckets(used to store key and value) in the Hash table , and the **initial capacity** is simply the capacity at the time  Hash table is created.

The **load factor** is a measure of how full the Hash table is allowed to get before its capacity is automatically increased.

- _Iterator_ offers standardized way of accessing the elements within a collection, one at a time. 
- _Spliterator_ is iterator that provide support for parallel iteration.
- _ListIterator_ extends Iterator to allow bidirectional traversal of a list, and the modification of elements
- [_ArrayList_](https://www.callicoder.com/java-arraylist/)
    
- [_LinkedList (baeldung.com)_](https://www.baeldung.com/java-linkedlist)  
  [_LinkedList (java8net.com)_](https://www.java8net.com/2020/03/linkedlist-in-java.html)

- [_HashSet_](https://www.baeldung.com/java-hashset)

- [_LinkedHashSet_](https://www.edureka.co/blog/linkedhashset-in-java)

- [_TreeSet_](https://www.java8net.com/2020/02/treeset-in-java.html)

- [_PriorityQueue_](https://www.callicoder.com/java-priority-queue)

- [_ArrayDeque_](https://www.baeldung.com/java-array-deque)
  
- [_EnumSet_](https://www.baeldung.com/java-enumset)
- _RandomAccess_ interface contains no members. However, by
  implementing this interface, a collection signals that it supports efficient
  random access to its elements.
  
- _SortedMap_ interface extends Map. It ensures that the entries are maintained in ascending order based on the keys
- _NavigableMap_ interface extends SortedMap and declares the behavior of
  a map that supports the retrieval of entries based on the closest match to a
  given key or keys
- [_WeakHashMap_](https://www.baeldung.com/java-weakhashmap)
- [_HashMap (baeldung.com)_](https://www.baeldung.com/java-hashmap)  
  [_HashMap (java8net.com)_](https://www.java8net.com/2020/01/how-hashmap-works-internally-in-java.html)
- [_TreeMap_](https://www.baeldung.com/java-treemap)
- [_LinkedHashMap_](https://www.baeldung.com/java-linked-hashmap)
- [_EnumMap_](https://www.baeldung.com/java-enum-map)
