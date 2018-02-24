package java7_3.chapter3;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
    private boolean[] freePrint;
    private Semaphore semaphore;
    private Lock lockPrinters;
    public PrintQueue(){
        freePrint=new  boolean[3];
        semaphore=new Semaphore(3);
        lockPrinters=new ReentrantLock();
        for(int  i=0;i<3;i++){
            freePrint[i]=true;
        }
    }
    public void printJob(Object document){
        try {
            semaphore.acquire();
            int assignedPrinter=getPrinter();
            long duration= (long) (Math.random()*10);
            System.out.printf("%s :printQueue :print a job in %d printer %d s\n",Thread.currentThread().getName(),assignedPrinter,duration);
            TimeUnit.SECONDS.sleep(duration);
            freePrint[assignedPrinter]=true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }

    public int getPrinter() {
        int ret=-1;
        try {
            lockPrinters.lock();
            for (int i = 0; i < freePrint.length; i++) {
                if (freePrint[i]) {
                    ret = i;
                    freePrint[i] = false;
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lockPrinters.unlock();
        }
        return ret;
    }
}
