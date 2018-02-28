package java7_5.chapter3;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

public class DocumentTask extends RecursiveTask<Integer>{
    private static final long serialVersionUID = -5013571541161108128L;
    private String[][] documents;
    private int start,end;
    private String word;

    public DocumentTask(String[][] documents, int start, int end, String word) {
        this.documents = documents;
        this.start = start;
        this.end = end;
        this.word = word;
    }

    @Override
    protected Integer compute() {
        Integer result = null;
        if((end-start)<10){
            result=processLine(documents,start,end,word);
        }else{
            int mid=(start+end)/2;
            DocumentTask task1=new DocumentTask(documents,start,mid,word);
            DocumentTask task2=new DocumentTask(documents,mid,end,word);
            invokeAll(task1,task2);
            try {
                result=groupResult(task1.get(),task2.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private Integer groupResult(Integer integer, Integer integer1) {
        return integer+integer1;
    }

    private Integer processLine(String[][] documents, int start, int end, String word) {
        List<LineTask> tasks=new ArrayList<>();
        for(int i=start;i<end;i++){
            LineTask task=new LineTask(documents[i],0,documents[i].length,word);
            tasks.add(task);
        }
        invokeAll(tasks);
        int result=0;
        for(int i=0;i<tasks.size();i++){
            try {
                result+=tasks.get(i).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        return new Integer(result);
    }
}
