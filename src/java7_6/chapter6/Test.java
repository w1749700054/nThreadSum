package java7_6.chapter6;

import java.util.Map;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class Test {
    public static void main(String[] args) {
        ConcurrentSkipListMap map=new ConcurrentSkipListMap();
        Thread[] threads=new Thread[25];
        int counter=0;
        for(char i='A';i<'Z';i++){
            Task task=new Task(map,String.valueOf(i));
            threads[counter]=new Thread(task);
            threads[counter].start();
            counter++;
        }
        for(int i=0;i<25;i++){
            try{
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Main:size of map %d\n",map.size());
        Map.Entry<String,Contact> element;
        Contact contact;
        element=map.firstEntry();
        contact=element.getValue();
        System.out.printf("Main:first entry:%s:%s\n",contact.getName(),contact.getPhone());
        element=map.lastEntry();
        contact=element.getValue();
        System.out.printf("main:last entry:%s:%s\n",contact.getName(),contact.getPhone());
        System.out.println("Main:submap from A1996 to B1002");
        ConcurrentNavigableMap <String,Contact> subMap=map.subMap("A1996","B1002");
        do {
            element=subMap.pollFirstEntry();
            if(element!=null){
                contact=element.getValue();
                System.out.printf("Main:%s:%s\n",contact.getName(),contact.getPhone());
            }
        }while(element!=null);

    }
}
