package java7_1;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class test1_3 {
    public static void main(String[] args) {
        Thread[] threads=new Thread[10];
        Thread.State[] states=new Thread.State[10];
        for(int i=0;i<10;i++){
            threads[i]=new Thread(new Caculator(i));
            if(i%2==0){
                threads[i].setPriority(Thread.MAX_PRIORITY);
            }else{
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("Thread "+i);
        }
        try {
            FileWriter writer=new FileWriter("log.text");
            PrintWriter pw=new PrintWriter(writer);
            for(int i=0;i<10;i++){
                System.out.println("Main:status of Thread_"+i+":"+threads[i].getState() );
            }
            for(int i=0;i<10;i++){
                threads[i].start();
            }
            boolean finish=false;
            while (!finish){
                for(int i=0;i<10;i++){
                    if(threads[i].getState()!=states[i]){
                        writerThreadInfo(pw,threads[i],states[i]);
                        states[i]=threads[i].getState();
                    }
                }
                finish=true;
                for(int  i=0;i<10;i++){
                    finish=finish&(threads[i].getState()==Thread.State.TERMINATED);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void writerThreadInfo(PrintWriter pw, Thread thread, Thread.State state) {
        pw.printf("Main: Id %d - %s\n",thread.getId(),thread.getName());
        pw.printf("Main: properties %d\n",thread.getPriority());
        pw.printf("Main: Old  State %s\n",state);
        pw.printf("Main： new State %s\n",thread.getState());
        pw.printf("Main:**********************************\n");
        pw.flush();
    }
}
