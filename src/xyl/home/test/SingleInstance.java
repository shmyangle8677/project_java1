package xyl.home.test;

/**
 *单例模式
 */
public class SingleInstance {
    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            new Thread(()->{
                MyClass myClass = MyClass.getInstance();
                //MyClass2 myClass = MyClass2.getInstance();
                System.out.println(Thread.currentThread().getName()+":"+myClass.hashCode());
            },"A"+i).start();
        }
    }
}

//单例模式-懒汉模式
class MyClass{
    private  static MyClass myClass;

    public MyClass() {
    }

    public static MyClass getInstance(){
        if (myClass == null){
            try {
                Thread.sleep(3000);
                synchronized (MyClass.class){
                    if(myClass == null)
                        myClass = new MyClass();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return myClass;
    }
}

//饿汉模式
class  MyClass2{
    private  static  MyClass2 myClass2=new MyClass2();
    public MyClass2() {
    }
    public  static  MyClass2 getInstance(){
        return myClass2;
    }
}