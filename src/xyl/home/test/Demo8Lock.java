package xyl.home.test;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

class Family {
    public synchronized  void  firstSon() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("*********my first son");
    }

    public static  synchronized  void secondSon(){
        System.out.println("*********my secondSon son");
    }
}

public class Demo8Lock {
    public static void main(String[] args) {
        Family family = new Family();
        new Thread(() -> {
            try {
                family.firstSon();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();

        new Thread(() -> {family.secondSon();},"B").start();
    }
}
