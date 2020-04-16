package xyl.home.service;

import java.util.concurrent.Callable;

public class ThreadCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("****成功进入****");
        return "Hello Menron";
    }
}
