package java7_1;

public class Caculator implements Runnable{
    private int number;
    public  Caculator(int number){
        this.number=number;
    }

    @Override
    public void run() {
        for(int i=1;i<=10;i++){
            System.out.printf("%s:%d*%d=%d\n",Thread.currentThread().getName(),number,i,number*i);
        }
    }
}
