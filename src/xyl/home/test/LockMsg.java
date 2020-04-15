package xyl.home.test;

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
