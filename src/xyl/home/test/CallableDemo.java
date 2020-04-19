package xyl.home.test;

import xyl.home.service.ThreadCallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask(new ThreadCallable());
        new Thread(futureTask,"A").start();
        String result = futureTask.get();
        System.out.println(result);

        /*双亲委派机制
        类加载器总共有4种
        1、根加类加载器
        2、扩展加载类器
        3、应用程序加载器
        4、自定义类加载器*/
        Cake cake = new Cake();
        System.out.println(cake.getClass().getClassLoader().getParent().getParent());
        System.out.println(cake.getClass().getClassLoader().getParent());
        System.out.println(cake.getClass().getClassLoader());
    }
}
