package java7_3.chapter2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class PrintQueue {
    private Semaphore semaphore;
    public PrintQueue(){
        semaphore=new Semaphore(1);
    }
    public void printJob(Object document){
        try{
//            semaphore.release();
            semaphore.acquire();
            long duration= (long) (Math.random()*10);
            System.out.printf("%s :printQueue printing an job during %d seconds \n",Thread.currentThread().getName(),duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }
}
