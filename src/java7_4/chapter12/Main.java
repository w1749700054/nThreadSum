package java7_4.chapter12;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) {
        RejectTaskController  controller=new RejectTaskController();
        ThreadPoolExecutor executor= (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        executor.setRejectedExecutionHandler(controller);
        System.out.println("Main :starting");
        for(int i=0;i<10;i++){
            Task task=new Task("task-"+i);
            executor.submit(task);
        }
        System.out.println("Main :shutdown executor");
        executor.shutdownNow();
        System.out.println("Main:sender another task");
        Task task=new Task("RejectTask");
        executor.submit(task);
        System.out.println("Main :end");

    }
}
