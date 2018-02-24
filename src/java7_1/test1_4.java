package java7_1;

public class test1_4 {
    public static void main(String[] args) {
        PrimeGenerator pg=new PrimeGenerator();
        pg.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pg.interrupt();

    }
}
