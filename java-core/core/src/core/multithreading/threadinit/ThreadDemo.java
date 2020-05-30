package core.multithreading.threadinit;

public class ThreadDemo {

    public static void main(String[] args) {
        NewThread nt = new NewThread();
        nt.t.start();
//        ExtendThread et = new ExtendThread();
//        et.start();
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Main Thread: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException exc) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread exiting");
    }
}

class NewThread implements Runnable {
    Thread t;

    public NewThread() {
        this.t = new Thread(this, "Demo Thread");
        System.out.println("Child thread: " + t);
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child thread: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException exc) {
            System.out.println("Child thread interrupted");
        }
        System.out.println("Exiting child thread");
    }
}

class ExtendThread extends Thread {

    public ExtendThread() {
        super("ExtendThread");
        System.out.println("Child thread: " + this);
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child thread: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException exc) {
            System.out.println("Child thread interrupted");
        }
        System.out.println("Exiting child thread");
    }
}