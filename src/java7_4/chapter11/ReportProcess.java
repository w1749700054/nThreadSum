package java7_4.chapter11;

import java.util.concurrent.*;

public class ReportProcess implements Runnable {
    private CompletionService<String> service;
    private boolean end;

    public ReportProcess(CompletionService<String> service) {
        this.service = service;
        end=false;
    }

    @Override
    public void run() {
        while(!end){
            try {
                Future<String> result=service.poll(20, TimeUnit.SECONDS);
                if(result!=null){
                    String report=result.get();
                    System.out.printf("ReportRecivice:report recivice:%s\n",report);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("report sender end");

    }

    public void setEnd(boolean end) {
        this.end = end;
    }
}
