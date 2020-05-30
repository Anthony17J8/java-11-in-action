package core.multithreading.interthreadcom;

public class PC {
    public static void main(String[] args) {
        Q q = new Q();
        Consumer c = new Consumer(q);
        Producer p = new Producer(q);

        p.t.start();
        c.t.start();
    }
}

class Q {
    int n;
    boolean valueSet = false;

    synchronized int get() {
        while (!valueSet) {
            try {
                wait();
            } catch (InterruptedException exc) {
                System.out.println("Interrupted in get()");
            }
        }
        System.out.println("Got: " + n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n) {
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException exc) {
                System.out.println("Interrupted in put()");
            }
        }
        this.n = n;
        System.out.println("Put: " + n);
        valueSet = true;
        notify();
    }
}

class Consumer implements Runnable {
    Q q;
    Thread t;

    public Consumer(Q q) {
        this.q = q;
        t = new Thread(this, "Consumer");
    }

    @Override
    public void run() {
        while (true) {
            q.get();
        }
    }
}

class Producer implements Runnable {
    Q q;
    Thread t;

    public Producer(Q q) {
        this.q = q;
        t = new Thread(this, "Producer");
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            q.put(i++);
        }
    }
}