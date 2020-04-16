package xyl.home.test;

import xyl.home.entity.Print1;

public class PrintMain {
    public static void main(String[] args) {
        Print1 print1=new Print1();
        new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                print1.print5();
            }
        },"A").start();
        new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                print1.print10();
            }
        },"B").start();
        new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                print1.print15();
            }
        },"C").start();
    }
}
