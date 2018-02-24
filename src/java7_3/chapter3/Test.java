package java7_3.chapter3;

public class Test {
    public static void main(String[] args) {
        PrintQueue printQueue=new PrintQueue();
        Thread[] threads=new Thread[10];
        for(int i=0;i<10;i++){
            threads[i]=new Thread(new Job(printQueue),"job-"+i);
        }
        for(int i=0;i<10;i++){
            threads[i].start();
        }
    }
}
