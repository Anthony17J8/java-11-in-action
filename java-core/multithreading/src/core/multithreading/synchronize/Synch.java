package core.multithreading.synchronize;

public class Synch {

    public static void main(String[] args) {
        Callme target = new Callme();
        Caller ob1 = new Caller("Hello", target);
        Caller ob2 = new Caller("Synchronized", target);
        Caller ob3 = new Caller("World", target);

        ob1.t.start();
        ob2.t.start();
        ob3.t.start();

        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException exc) {
            System.out.println("Interrupted");
        }
    }
}

class Callme {
   synchronized void call(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException exc) {
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }
}

class Caller implements Runnable {

    String msg;
    Callme target;
    Thread t;

    public Caller(String msg, Callme target) {
        this.msg = msg;
        this.target = target;
        t = new Thread(this);
    }

    @Override
    public void run() {
        target.call(msg);
    }
}
