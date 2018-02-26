package java7_4.chapter6;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Task implements Callable<Result> {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public Result call() throws Exception {
        System.out.printf("%s :start\n",this.name);
        try{
            long duration= (long) (Math.random()*10);
            System.out.printf("%s:waiting for %d second for result\n",name,duration);
            TimeUnit.SECONDS.sleep(duration);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        int value=0;
        for(int i=0;i<5;i++){
            value+=(int)(Math.random()*100);
        }
        Result result=new Result();
        result.setId(name);
        result.setValue(value);
        System.out.printf(this.name+":Ends\n");
        return result;
    }
}
