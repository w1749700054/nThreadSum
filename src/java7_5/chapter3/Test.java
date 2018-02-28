package java7_5.chapter3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        DoumentMock docment=new DoumentMock();
        String [][] documents=docment.genertorDocument(100,1000,"the");
        DocumentTask task=new DocumentTask(documents,0,100,"the");
        ForkJoinPool pool=new ForkJoinPool();
        pool.execute(task);
        do{
            System.out.println("********************************************");
            System.out.printf("Main:parallelism:%d\n",pool.getParallelism());
            System.out.printf("Main:active Threads:%d\n",pool.getActiveThreadCount());
            System.out.printf("Main:task count %d\n",pool.getQueuedTaskCount());
            System.out.printf("Main:steal count %d\n",pool.getStealCount());
            System.out.println("*************************************************");
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (!task.isDone());
        pool.shutdown();
        try{
            pool.awaitTermination(1,TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try{
            System.out.printf("Main:the word appears %d in the document\n",task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
