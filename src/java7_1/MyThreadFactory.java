package java7_1;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {
    private String name;
    private List<String> staties;
    private int count;
    public MyThreadFactory(String name){
        count=0;
        this.name=name;
        staties=new ArrayList<>();
    }
    @Override
    public Thread newThread(Runnable r) {
        Thread t=new Thread(name);
        count++;
        staties.add(String.format("create thread %d with name %s on%s\n",t.getId(),t.getName(),new Date()));
        return t;
    }
    public String getStaties(){
        StringBuffer sb=new StringBuffer();
        Iterator it=staties.iterator();
        while(it.hasNext()){
            sb.append(it.next()).append("\n");
        }
        return sb.toString();
    }
}
