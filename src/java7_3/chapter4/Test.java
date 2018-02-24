package java7_3.chapter4;

public class Test {
    public static void main(String[] args) {
        VideoConference videoConference=new VideoConference(10);
        Thread videoThread=new Thread(videoConference);
        videoThread.start();
        Thread[] partThread=new Thread[10];
        for(int i=0;i<10;i++){
            Partication part=new Partication(videoConference,"participant-"+i);
            partThread[i]=new Thread(part);
        }
        for(int i=0;i<10;i++){
            partThread[i].start();
        }
    }
}
