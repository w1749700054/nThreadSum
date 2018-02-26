package java7_4.chapter6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {
    public static void main(String[] args) {
        ExecutorService es= Executors.newCachedThreadPool();
        List<Task> taskList=new ArrayList<>();
        for(int i=0;i<3;i++){
            Task task=new Task("task-"+i);
            taskList.add(task);
        }
        List<Future<Result>> futureList=new ArrayList<>();
        try{
            futureList=es.invokeAll(taskList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        es.shutdown();
        for(int i=0;i<futureList.size();i++){
            try {
                Result result=futureList.get(i).get();
                System.out.println(result.getId()+":"+result.getValue());

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
