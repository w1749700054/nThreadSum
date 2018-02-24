package java7_1;

import java.util.concurrent.TimeUnit;

public class Test1_5 {
    public static void main(String[] args) {
        FileSearch fileSearch=new FileSearch("C:\\","hiberfil.sys");
        Thread thread=new Thread(fileSearch);
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
