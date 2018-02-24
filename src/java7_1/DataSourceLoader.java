package java7_1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DataSourceLoader implements Runnable {
    @Override
    public void run() {
        System.out.printf("begining data sourceloader %s\n",new Date());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("ending data sourceloader %s\n",new Date());
    }
}
