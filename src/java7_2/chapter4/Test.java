package java7_2.chapter4;

public class Test {
    public static void main(String[] args) {
        EventStorage eventStorage=new EventStorage();
        Consumer consumer=new Consumer(eventStorage);
        Productor productor=new Productor(eventStorage);
        new Thread(consumer).start();
        new Thread(productor).start();
    }
}
