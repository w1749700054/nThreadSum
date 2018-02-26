package java7_4.chapter8;


import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        ScheduledExecutorService executor= Executors.newScheduledThreadPool(1);
        System.out.println("Main: starting at \n"+new Date());
        Task task=new Task("task");
        ScheduledFuture<?> future=executor.scheduleAtFixedRate(task,1,2,TimeUnit.SECONDS);
        for(int i=0;i<10;i++){
            System.out.printf("Main:Delay:%d\n",future.getDelay(TimeUnit.SECONDS));
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
        try{
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Main:finish at %s\n",new Date());
    }
}
