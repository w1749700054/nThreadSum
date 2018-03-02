package java7_7.chapter2;

import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class MyExecutor extends ThreadPoolExecutor {
    private ConcurrentHashMap<String,Date> map;

    public MyExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        map=new ConcurrentHashMap();
    }

    @Override
    public void shutdown() {
        System.out.println("MyExecutor is going  to shutdown");
        System.out.printf("MyExecutor executor task :%d\n",getCompletedTaskCount());
        System.out.printf("MyExecutor running task: %d\n",getActiveCount());
        System.out.printf("MyExecutor pending task: %d\n",getQueue().size());
        super.shutdown();
    }

    @Override
    public List<Runnable> shutdownNow() {
        System.out.println("MyExecutor immediately is going  to shutdown");
        System.out.printf("MyExecutor executor task :%d\n",getCompletedTaskCount());
        System.out.printf("MyExecutor running task: %d\n",getActiveCount());
        System.out.printf("MyExecutor pending task: %d\n",getQueue().size());
        return super.shutdownNow();
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        System.out.printf("MyExecutor is begining to %s:%s\n",t.getName(),r.hashCode());
        map.put(String.valueOf(r.hashCode()),new Date());
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        Future<?> result= (Future<?>) r;
        try{
            System.out.println("*********************************************");
            System.out.println("MyExecutor:A task has bean finish");
            System.out.printf("MyExecutor:Result:%s\n",result.get());
            Date startDate=map.remove(String.valueOf(r.hashCode()));
            Date endDate=new Date();
            long diff=endDate.getTime()-startDate.getTime();
            System.out.printf("MyExecutor:Duration:%d\n",diff);
            System.out.println("************************************************");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
