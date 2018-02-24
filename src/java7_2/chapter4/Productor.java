package java7_2.chapter4;

public class Productor implements Runnable {
    private EventStorage eventStorage;

    public Productor(EventStorage eventStorage) {
        this.eventStorage = eventStorage;
    }

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            eventStorage.set();
        }
    }
}
