package java7_6.chapter5;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Event implements Delayed{
    private Date startDate;

    public Event(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        Date date=new Date();
        long diff=startDate.getTime()-date.getTime();
        return unit.convert(diff,TimeUnit.MILLISECONDS);
    }


    @Override
    public int compareTo(Delayed o) {
        long result=this.getDelay(TimeUnit.NANOSECONDS)-o.getDelay(TimeUnit.NANOSECONDS);
        if(result>0){
            return 1;
        }
        if(result>0){
            return -1;
        }
        return 0;
    }
}
