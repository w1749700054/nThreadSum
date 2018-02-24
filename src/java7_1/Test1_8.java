package java7_1;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test1_8 {
    public static void main(String[] args) {
        Deque<Event> deque=new ArrayDeque<Event>();
        WriterTask writerTask=new WriterTask(deque);
        for(int i=0;i<3;i++){
            Thread thread=new Thread(writerTask);
            thread.start();
        }
        ClearTask clearTask=new ClearTask(deque);
        clearTask.start();
    }
}
