package java7_1;

public class ExceptionHandle implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("an exception has bean caught");
        System.out.printf("Thread:%s\n",t.getId());
        System.out.printf("Exception:%s :%s\n",e.getClass().getName(),e.getMessage());
        System.out.printf("Stack trace:\n");
        e.printStackTrace(System.out);
        System.out.printf("Thread Status:%s\n",t.getState());
    }
}
