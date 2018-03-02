package java7_7.chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        MyExecutor myExecutor=new MyExecutor(2,4,1000, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>());
        List<Future<String>> results=new ArrayList<>();
        for(int i=0;i<10;i++){
            SleepTwoSecondTask task=new SleepTwoSecondTask();
            Future future=myExecutor.submit(task);
            results.add(future);
        }
        for(int i=0;i<5;i++){
            try {
                String result=results.get(i).get();
                System.out.printf("Main:Result for task:%d:%s\n",i,result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        myExecutor.shutdown();
        for(int i=5;i<10;i++){
            try {
                String result=results.get(i).get();
                System.out.printf("Main:Result for task:%d,%s\n",i,result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        try {
            myExecutor.awaitTermination(1,TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main:the end");
    }
}
