package java7_1;

import java.util.concurrent.TimeUnit;

public class Test1_11 {
    public static void main(String[] args) {
        ThreadGroup threadGroup=new ThreadGroup("searcher");
        Result result=new Result();
        SearchTask searchTask=new SearchTask(result);
        for(int i=0;i<10;i++){
            Thread thread=new Thread(threadGroup,searchTask);
            thread.start();
            try{
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Number of Threads :%d\n",threadGroup.activeCount());
        System.out.printf("Information about the Thread Group\n");
        threadGroup.list();
        Thread[] threads=new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        for(int  i=0;i<threadGroup.activeCount();i++){
            System.out.printf("Thread %s:%s\n",threads[i].getName(),threads[i].getState());
        }
        writeFinish(threadGroup);
        threadGroup.interrupt();
    }

    private static void writeFinish(ThreadGroup threadGroup) {
        while(threadGroup.activeCount()>9){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
