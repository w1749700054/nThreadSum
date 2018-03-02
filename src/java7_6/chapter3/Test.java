package java7_6.chapter3;

import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<String> list=new LinkedBlockingQueue<>(3);
        Client client=new Client(list);
        Thread thread=new Thread(client);
        thread.start();
        for(int i=0;i<5;i++){
            for(int j=0;j<3;j++){
                String request=list.take();
                System.out.printf("Main:request:%s at %s size:%d\n",request,new Date(),list.size());
            }
            TimeUnit.MILLISECONDS.sleep(300);
        }
        System.out.println("Main:End");
    }
}
