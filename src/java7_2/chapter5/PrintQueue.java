package java7_2.chapter5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
    private Lock queueLock=new ReentrantLock();
    public void printJob(Object document){
        queueLock.lock();
        long doration= (long) (Math.random()*10000);
        System.out.println(Thread.currentThread().getName()+":printQueue :print a job "+(doration/1000)+" seconds");
        try {
            Thread.sleep(doration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            queueLock.unlock();
        }
    }

}
