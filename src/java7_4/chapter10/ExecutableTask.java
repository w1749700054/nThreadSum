package java7_4.chapter10;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ExecutableTask implements Callable<String> {
    private String name;

    public ExecutableTask(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String call() throws Exception {
        long duration= (long) (Math.random()*10);
        System.out.printf("%s  :waiting  result for %d seconds \n",name,duration);
        TimeUnit.SECONDS.sleep(duration);
        return "Hello world i'm"+name;
    }
}
