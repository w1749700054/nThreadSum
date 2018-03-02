package java7_6.chapter4;

public class Event implements Comparable<Event> {
    private int  thread;
    private int property;

    public Event(int thread, int property) {
        this.thread = thread;
        this.property = property;
    }

    public int getThread() {
        return thread;
    }

    public int getProperty() {
        return property;
    }


    @Override
    public int compareTo(Event e) {
        if(this.property>e.property){
            return -1;
        }
        if(this.property<e.property){
            return 1;
        }
        return 0;
    }
}
