package xyl.home.test;

import java.util.Random;

public class Perm {

    public static void main(String[] args) {
        long maxMemory = Runtime.getRuntime().maxMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("-Xmx:"+maxMemory/(double)1024/1024+"MB");
        System.out.println("-Xms:"+totalMemory/(double)1024/1024+"MB");
        System.out.println(Runtime.getRuntime().availableProcessors());
        String str = "Hello Jack:";
        while (true){
            str += str +new Random().nextInt(8888888)+new Random().nextInt(999999);
        }
    }
}