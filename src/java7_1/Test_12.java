package java7_1;

public class Test_12 {
    public static void main(String[] args) {
        MyThreadGroup myThreadGroup=new MyThreadGroup("myThreadGroup");
        Task_12 task=new Task_12();
        for(int i=0;i<2;i++){
            Thread thread=new Thread(myThreadGroup,task);
            thread.start();
        }
    }
}
