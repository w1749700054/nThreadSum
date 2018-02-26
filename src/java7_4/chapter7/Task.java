package java7_4.chapter7;

import java.util.Date;
import java.util.concurrent.Callable;

public class Task implements Callable {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public Object call() throws Exception {
        System.out.printf("%s :start at %s\n",name,new Date());
        return "hello world";
    }
}
