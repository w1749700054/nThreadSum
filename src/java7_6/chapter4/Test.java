package java7_6.chapter4;

import java.util.concurrent.PriorityBlockingQueue;

public class Test {
    public static void main(String[] args) {
        PriorityBlockingQueue<Event> queue=new PriorityBlockingQueue<>();
        Thread[] taskThreads=new Thread[5];
        for(int i=0;i<taskThreads.length;i++){
            Task task=new Task(i,queue);
            taskThreads[i]=new Thread(task);
        }
        for(int i=0;i<taskThreads.length;i++){
            taskThreads[i].start();
        }
        for(int i=0;i<taskThreads.length;i++){
            try {
                taskThreads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Main queue size: %d\n",queue.size());
        for(int i=0;i<taskThreads.length*1000;i++){
            Event event=queue.poll();
            System.out.printf("Thread :%s,Priority %d\n",event.getThread(),event.getProperty());
        }
        System.out.printf("Main:queue size %d\n",queue.size());
        System.out.println("Main:End of the program");
    }
}
