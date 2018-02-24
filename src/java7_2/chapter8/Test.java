package java7_2.chapter8;



public class Test {
    public static void main(String[] args) {
        FileMock mock=new FileMock(100,10);
        Buffer buffer=new Buffer(20);
        Producer producer=new Producer(mock,buffer);
        Thread producerThread=new Thread(producer,"producer");
        Consumer[] consumers=new Consumer[3];
        Thread[] consumerThreads=new Thread[3];
        for(int i=0;i<3;i++){
            consumers[i]=new Consumer(buffer);
            consumerThreads[i]=new Thread(consumers[i],"consumer-"+i);
        }
        producerThread.start();
        for(int i=0;i<3;i++){
            consumerThreads[i].start();
        }
    }
}
