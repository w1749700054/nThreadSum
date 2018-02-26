package java7_4.chapter2;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {
    private ThreadPoolExecutor executor;

    public Server() {
        this.executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    }
    public void executorTask(Task task){
        System.out.printf("Server:A new Task has Arrived");
        executor.execute(task);
        System.out.printf("Server:Pool size:%d\n",executor.getPoolSize());
        System.out.printf("Server:Active Count: %d\n",executor.getActiveCount());
        System.out.printf("Server:Completed Tasks:%d\n",executor.getCompletedTaskCount());
    }
    public void endTask(){
        executor.shutdown();
    }
}
