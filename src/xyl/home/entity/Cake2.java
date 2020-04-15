package xyl.home.entity;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cake2 {
    int number=0;
    private Lock lock=new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void make() throws InterruptedException {
        lock.lock();
        try {
            while (number != 0) {
                //this.wait();
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //this.notifyAll();
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void sale() throws InterruptedException {
        lock.lock();
        try {
            while (number == 0) {
                //this.wait();
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //this.notifyAll();
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
