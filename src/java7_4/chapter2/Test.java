package java7_4.chapter2;

public class Test {
    public static void main(String[] args) {
        Server server=new Server();
        for(int i=0;i<100;i++){
            Task task=new Task("task_"+i);
            server.executorTask(task);
        }
        server.endTask();
    }
}
