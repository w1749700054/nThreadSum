package java7_4.chapter10;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ResultTask extends FutureTask<String> {
    private String name;

    public ResultTask(Callable<String> callable) {
        super(callable);
        this.name=((ExecutableTask)callable).getName();
    }

    @Override
    protected void done() {
        if(isCancelled()){
            System.out.printf("%s has bean cancel\n",name);
        }else {
            System.out.printf("%s has finished\n",name);
        }
    }
}
