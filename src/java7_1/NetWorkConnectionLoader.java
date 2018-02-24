package java7_1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NetWorkConnectionLoader implements Runnable {
    @Override
    public void run() {
        System.out.printf("begining data networkConnectionLoader %s\n",new Date());
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("ending data networkConnectionLoader %s\n",new Date());
    }
}
