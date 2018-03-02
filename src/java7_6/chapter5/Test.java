package java7_6.chapter5;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        DelayQueue<Event> queue=new DelayQueue<>();
        Thread[] threads=new Thread[5];
        for(int i=0;i<threads.length;i++){
            Task task=new Task(i+1,queue);
            threads[i]=new Thread(task);
        }
        for(int i=0;i<threads.length;i++){
            threads[i].start();
        }
        for(int i=0;i<threads.length;i++){
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread join");
        do {
            int count=0;
            Event event;
            do{
                event=queue.poll();
                if(event!=null)count++;
            }while(event!=null);
            System.out.printf("At %s you have read %d events\n",new Date(),count);
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while(queue.size()>0);
    }
}
