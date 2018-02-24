package java7_1;

import java.util.concurrent.TimeUnit;

public class Test1_6 {
    public static void main(String[] args) {
        FileClock clock=new FileClock();
        Thread thread=new Thread(clock);
        thread.start();
        try{
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
