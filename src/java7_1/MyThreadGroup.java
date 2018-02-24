package java7_1;

public class MyThreadGroup extends ThreadGroup {
    String name;
    public MyThreadGroup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("the thread %s throw an exception\n",t.getId());
        e.printStackTrace(System.out);
        System.out.printf("terminal  the rest of thread\n");
        interrupt();
    }
}
