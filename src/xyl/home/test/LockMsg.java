package xyl.home.test;

import xyl.home.entity.Cake2;

class Cake{
    int number=0;
    public synchronized void make() throws InterruptedException {
        while (number !=0){
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        this.notifyAll();
    }

    public synchronized void sale() throws InterruptedException {
        while (number == 0 ){
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        this.notifyAll();
    }
}

public class LockMsg {
    public static void main(String[] args) {
        //oldMethod();
        newMethod();
    }

    private static void newMethod() {
        Cake2 cake2 = new Cake2();
        new Thread(() -> {
            for(int i=1;i<=10;i++){
                try {
                    cake2.make();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(() -> {
            for(int i=1;i<=10;i++){
                try {
                    cake2.sale();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

        new Thread(() -> {
            for(int i=1;i<=10;i++){
                try {
                    cake2.make();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();


        new Thread(() -> {
            for(int i=1;i<=10;i++){
                try {
                    cake2.sale();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }

    private static void oldMethod() {
        Cake cake = new Cake();
        new Thread(() -> {
            for(int i=1;i<=10;i++){
                try {
                    cake.make();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(() -> {
            for(int i=1;i<=10;i++){
                try {
                    cake.sale();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

        new Thread(() -> {
            for(int i=1;i<=10;i++){
                try {
                    cake.make();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();


        new Thread(() -> {
            for(int i=1;i<=10;i++){
                try {
                    cake.sale();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}
