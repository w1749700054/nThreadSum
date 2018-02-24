package java7_1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FileClock implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.printf("%s\n", new Date());
            try{
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.printf("the fileClock has bean interrupted");
                return;
            }
        }
    }
}
