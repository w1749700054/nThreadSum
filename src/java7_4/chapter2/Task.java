package java7_4.chapter2;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable{
    private Date initDate;
    private String name;

    public Task(String name) {
        initDate=new Date();
        this.name = name;
    }

    @Override
    public void run() {
        System.out.printf("%s :Task %s:Create on %s\n",Thread.currentThread().getName(),name,initDate);
        System.out.printf("%s :Task %s :start  on %s\n",Thread.currentThread().getName(),name,new Date());
        try{
            long duration= (long) (Math.random()*10);
            System.out.printf("%s :task %s :do a task during %d second\n", Thread.currentThread().getName(),name,duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s :task %s : finish task on :%s\n",Thread.currentThread().getName(),name,new Date());
    }
}
