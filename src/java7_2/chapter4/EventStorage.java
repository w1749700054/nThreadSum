package java7_2.chapter4;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class EventStorage {
    private int size;
    private List<Date> storge;
    public EventStorage(){
        size=10;
        storge=new LinkedList();
    }
     void set(){
        while(storge.size()==size){
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        storge.add(new Date());
        System.out.printf("set:%d\n",storge.size());
//        notifyAll();
    }
      void get(){
        while(storge.size()==0){
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        System.out.printf("get :%d:%s\n",storge.size(),((LinkedList)storge).poll());
//        notifyAll();
    }
}
