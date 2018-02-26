package java7_4.chapter11;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ReportGenertor implements Callable<String> {
    private String sender;
    private String title;

    public ReportGenertor(String sender, String title) {
        this.sender = sender;
        this.title = title;
    }

    @Override
    public String call() throws Exception {
        long duration= (long) (Math.random()*10);
        System.out.printf("%s_%s:reportGenertor :generting a report during %d seconds\n",this.sender,this.title,duration);
        TimeUnit.SECONDS.sleep(duration);
        String result=sender+":"+title;
        return result;
    }
}
