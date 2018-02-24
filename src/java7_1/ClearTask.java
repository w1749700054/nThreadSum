package java7_1;

import java.util.Date;
import java.util.Deque;

public class ClearTask extends Thread {
    private Deque<Event> deque;
    public ClearTask(Deque deque){
        this.deque=deque;
        setDaemon(true);
    }
    @Override
    public void run() {
        while (true){
            Date date=new Date();
            clear(date);
        }
    }

    private void clear(Date date) {
        long difference;
        boolean delete;
        if(deque.size()==0){
            return;
        }
        delete=false;
        do{
            Event event=deque.getLast();
            difference=date.getTime()-event.getDate().getTime();
            if(difference>10000){
                System.out.printf("clean %s\n",event.getEvent());
                deque.removeLast();
                delete=true;
            }
        }while(difference>10000);
        if(delete){
            System.out.printf("size of deque %d\n",deque.size());
        }
    }
}
