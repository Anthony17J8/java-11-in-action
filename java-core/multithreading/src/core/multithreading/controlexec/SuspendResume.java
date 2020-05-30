package core.multithreading.controlexec;

public class SuspendResume {

    public static void main(String[] args) {
        NewThread ob1 = new NewThread("One");
        NewThread ob2 = new NewThread("Two");

        ob1.t.start();
        ob2.t.start();

        try {
            Thread.sleep(1000);
            ob1.suspend();
            System.out.println("Suspending thread One");
            Thread.sleep(1000);
            ob1.resume();
            System.out.println("Resuming thread One");
            ob2.suspend();
            System.out.println("Suspending thread Two");
            Thread.sleep(1000);
            ob2.resume();
            System.out.println("Resuming thread Two");
        } catch (InterruptedException exc) {
            System.out.println("Main interrupted");
        }

        try {
            ob1.t.join();
            ob2.t.join();
        } catch (InterruptedException exc) {
            System.out.println("Main interrupted");
        }
        System.out.println("Main thread exiting");
    }
}

class NewThread implements Runnable {
    String thName;
    Thread t;
    boolean suspendFlag;

    public NewThread(String thName) {
        this.thName = thName;
        t = new Thread(this, thName);
        System.out.println("New thread: " + t);
        suspendFlag = false;
    }

    @Override
    public void run() {
        try {
            for (int i = 15; i > 0; i--) {
                System.out.println(thName + ": " + i);
                Thread.sleep(200);
                synchronized (this) {
                    if (suspendFlag) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException exc) {
            System.out.println(thName + " interrupted");
        }
    }

    synchronized void suspend() {
        suspendFlag = true;
    }

    synchronized void resume() {
        suspendFlag = false;
        notify();
    }
}