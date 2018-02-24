package java7_2.chapter8;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
    private LinkedList<String> buffer;
    private int maxSize;
    private ReentrantLock lock;
    private Condition lines,space;
    private boolean pendingLine;

    public Buffer(int maxSize) {
        this.maxSize = maxSize;
        buffer=new LinkedList<>();
        lock=new ReentrantLock();
        lines=lock.newCondition();
        space=lock.newCondition();
        pendingLine=true;
    }
    public void insert(String line){
        lock.lock();
        try {
        while(buffer.size()==maxSize){
                space.await();
        }
        buffer.offer(line);
        lines.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public String get(){
        String line=null;
        lock.lock();
        try{
            while((buffer.size()==0)&&(hasPendingLine())){
                lines.await();
            }
            if(hasPendingLine()){
                line=buffer.poll();
                System.out.printf("%s readLine:%d\n",Thread.currentThread().getName(),buffer.size());
                space.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return line;
    }

    public void setPendingLine(boolean pendingLine) {
        this.pendingLine = pendingLine;
    }

    public  boolean hasPendingLine() {
        return pendingLine||buffer.size()>0;
    }
}
