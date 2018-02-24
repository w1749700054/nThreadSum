package java7_3.chapter4;

import java.util.concurrent.CountDownLatch;

public class VideoConference implements Runnable{
    private final CountDownLatch countDownLatch;
    public VideoConference(int number){
        countDownLatch=new CountDownLatch(number);
    }
    @Override
    public void run() {
        System.out.printf("Video Conference Initialization :%d printers\n",countDownLatch.getCount());
        try {
            countDownLatch.await();
            System.out.printf("VideoConference :All participants have come");
            System.out.printf("let's start");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void arrive(String name){
        System.out.printf("%s arrived\n",name);
        countDownLatch.countDown();
        System.out.printf("VideoConference waiting for %d conferencers\n",countDownLatch.getCount());

    }
}
