package java7_2.chapter6;

public class Test {
    public static void main(String[] args) {
        PricesInfo pricesInfo=new PricesInfo();
        Thread[] threads=new Thread[5];
        Reader reader=new Reader(pricesInfo);
        for(int i=0;i<5;i++){
            threads[i]=new Thread(reader);
        }
        Thread[] writeThreads=new Thread[5];
        Writer writer=new Writer(pricesInfo);
        for(int i=0;i<5;i++){
            writeThreads[i]=new Thread(writer);
        }
        for(int i=0;i<5;i++){
            threads[i].start();
            writeThreads[i].start();
        }
    }
}
