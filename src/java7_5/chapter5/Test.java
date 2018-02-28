package java7_5.chapter5;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        int[] array=new int[100];
        Task task=new Task(array,0,100);
        ForkJoinPool pool=new ForkJoinPool();
        pool.execute(task);
        pool.shutdown();
//        try {
//            pool.awaitTermination(1, TimeUnit.DAYS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        if(task.isCompletedAbnormally()){
//            System.out.println("Main :task has an exception\n");
//            System.out.printf("Main:%s",task.getException());
//        }
        System.out.printf("Main:result",task.join());
    }
}
