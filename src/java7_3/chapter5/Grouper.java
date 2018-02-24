package java7_3.chapter5;

public class Grouper implements Runnable {
    private Result result;

    public Grouper(Result result) {
        this.result = result;
    }

    @Override
    public void run() {
        int finalResult=0;
        System.out.println("Group :processing result....\n");
        int[] data=result.getData();
        for(int number:data){
            finalResult+=number;
        }
        System.out.printf("Group total result :%d.\n",finalResult);
    }
}
