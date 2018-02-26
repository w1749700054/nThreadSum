package java7_4.chapter11;

import java.util.concurrent.CompletionService;

public class RequestGenertor implements Runnable {
    private String name;
    private CompletionService complete;

    public RequestGenertor(String name, CompletionService complete) {
        this.name = name;
        this.complete = complete;
    }

    @Override
    public void run() {
        ReportGenertor report=new ReportGenertor(name,"report");
        complete.submit(report);
    }
}
