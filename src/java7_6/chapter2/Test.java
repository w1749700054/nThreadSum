package java7_6.chapter2;

import java.util.concurrent.ConcurrentLinkedDeque;

public class Test {
    public static void main(String[] args) {
        ConcurrentLinkedDeque<String> list=new ConcurrentLinkedDeque();
        Thread[] threads=new Thread[100];
        for(int i=0;i<100;i++){
            threads[i]=new Thread(new AddTask(list));
            threads[i].start();
        }
        System.out.printf("Main:%d thread has bean lanch\n",threads.length);
        for(int i=0;i<100;i++){
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Main:size of list %d\n",list.size());
        for(int i=0;i<threads.length;i++){
            threads[i]=new Thread(new PollTask(list));
            threads[i].start();
        }
        System.out.printf("Main:%d thread addTask has bean lanch\n",threads.length);
        for(int i=0;i<threads.length;i++){
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Main size of list %d",list.size());
    }
}
