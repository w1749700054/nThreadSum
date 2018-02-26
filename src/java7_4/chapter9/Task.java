package java7_4.chapter9;

import java.util.concurrent.Callable;

public class Task implements Callable<String> {
    @Override
    public String call() throws Exception {
        while(true){
            System.out.printf("Task:task\n");
            Thread.sleep(100);
        }
    }
}
