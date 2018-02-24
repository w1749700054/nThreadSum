package java7_1;

public class Test1_9 {
    public static void main(String[] args) {
        Task task=new Task();
        Thread thread=new Thread(task);
        thread.setUncaughtExceptionHandler(new ExceptionHandle());
        thread.start();
    }
}
