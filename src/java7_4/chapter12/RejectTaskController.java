package java7_4.chapter12;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class RejectTaskController implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.printf("RejectTask :the task %s has bean reject\n",r.toString());
        System.out.printf("RejectTask: the poolExecutor: %s\n ",executor.toString());
        System.out.printf("RejectTaskController:Terminaling :%s\n",executor.isTerminating());
        System.out.printf("RejectTaskController:Terminaling:%s\n",executor.isTerminated());
    }
}
