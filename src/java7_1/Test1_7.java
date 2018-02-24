package java7_1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Test1_7 {
    public static void main(String[] args) {
        DataSourceLoader ds=new DataSourceLoader();
        NetWorkConnectionLoader nk=new NetWorkConnectionLoader();
        Thread dsThread=new Thread(ds,"DataSourceLoader");
        Thread nkThread=new Thread(nk,"NetworkConnectionLoader");
        dsThread.start();
        nkThread.start();
        try {
            dsThread.join(1000);
            nkThread.join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Main:Configuration has bean loader :%s\n",new Date());
    }
}
