package java7_4.chapter10;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        ExecutorService executor=Executors.newCachedThreadPool();
        ResultTask[] tasks=new ResultTask[5];
        for(int i=0;i<5;i++){
            ExecutableTask exeTask=new ExecutableTask("task-"+i);
            tasks[i]=new ResultTask(exeTask);
            executor.submit(tasks[i]);
        }
        try{
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i=0;i<5;i++){
            tasks[i].cancel(true);
        }
        for(int i=0;i<tasks.length;i++){
            try {
                if (!tasks[i].isCancelled()) {
                    String name = tasks[i].get();
                    System.out.printf("%s:\n",name);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}
