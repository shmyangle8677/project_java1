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

        Cake cake = new Cake();
        System.out.println(cake.getClass().getClassLoader().getParent().getParent());
        System.out.println(cake.getClass().getClassLoader().getParent());
        System.out.println(cake.getClass().getClassLoader());
    }
}
