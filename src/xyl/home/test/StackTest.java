package xyl.home.test;

public class StackTest {

    public void  va(){
        System.out.println("******"+Thread.currentThread().getName());
        va();
    }
    public static void main(String[] args) {
        new StackTest().va();
    }
}
