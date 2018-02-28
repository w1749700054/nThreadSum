package java7_4.chapter12;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Task "+name+" starting\n");
        try {
            long duration = (long) (Math.random() * 10);
            System.out.printf("%s do working %d seconds\n", name, duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("task %s: end\n",name);
    }

    @Override
    public String toString() {
        return name;
    }
}
