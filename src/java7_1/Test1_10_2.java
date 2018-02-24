package java7_1;

import java.util.concurrent.TimeUnit;

public class Test1_10_2 {
    public static void main(String[] args) {
        SafeTask sTask=new SafeTask();
        for(int i=0;i<10;i++){
            Thread thread=new Thread(sTask);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
