package java7_4.chapter7;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        ScheduledExecutorService executor= Executors.newScheduledThreadPool(1);
        System.out.println("Main: starting at "+new Date());
        for(int i=0;i<5;i++){
            Task task=new Task("task-"+i);
            executor.schedule(task,i+1, TimeUnit.SECONDS);
        }
        executor.shutdown();
        try {
            executor.awaitTermination(1,TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("the end "+new Date());
    }
}
