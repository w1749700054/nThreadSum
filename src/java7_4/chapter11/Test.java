package java7_4.chapter11;

import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) {
        ExecutorService executor= Executors.newCachedThreadPool();
        CompletionService service=new ExecutorCompletionService(executor);
        RequestGenertor genertor=new RequestGenertor("face",service);
        RequestGenertor onlineGenertor=new RequestGenertor("online",service);
        ReportProcess process=new ReportProcess(service);
        Thread generThread=new Thread(genertor);
        Thread onlineThread=new Thread(onlineGenertor);
        Thread processThread=new Thread(process);
        System.out.println("Main :start thread");
        generThread.start();
        onlineThread.start();
        processThread.start();
        try{
            System.out.println("Main ;waiting for Thread executor");
            onlineThread.join();
            generThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("shut down thread executor");
        executor.shutdown();
        try{
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        process.setEnd(true);
        System.out.println("Main-end");
    }
}
