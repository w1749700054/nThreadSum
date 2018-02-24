package java7_1;

public class Test_13 {
    public static void main(String[] args) {
        MyThreadFactory myThreadFactory=new MyThreadFactory("MyThreadFactory");
        Task_13 task=new Task_13();
        Thread thread;
        for(int i=0;i<10;i++){
            thread=myThreadFactory.newThread(task);
            thread.start();
        }
        System.out.printf("Factory stats\n");
        System.out.printf("%s\n",myThreadFactory.getStaties());
    }
}
