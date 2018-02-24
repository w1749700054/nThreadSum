package java7_3.chapter4;

import java.util.concurrent.TimeUnit;

public class Partication implements Runnable {
    private VideoConference videoConference;
    private String name;
    public Partication(VideoConference videoConference,String name) {
        this.videoConference = videoConference;
        this.name=name;
    }

    @Override
    public void run() {
        long duration= (long) (Math.random()*10);
        try {
            TimeUnit.SECONDS.sleep(duration);
            videoConference.arrive(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
