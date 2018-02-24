package java7_2.chapter5;

public class Job implements Runnable{
    private  PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.printf("%s going to print a document\n",Thread.currentThread().getName());
        printQueue.printJob(new Object());
        System.out.printf("%s has bean print\n",Thread.currentThread().getName());
    }
}
