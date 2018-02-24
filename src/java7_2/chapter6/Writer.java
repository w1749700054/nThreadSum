package java7_2.chapter6;

import java.util.Map;

public class Writer implements Runnable {
    private  PricesInfo pricesInfo;

    public Writer(PricesInfo pricesInfo) {
        this.pricesInfo = pricesInfo;
    }

    @Override
    public void run() {
        for(int i=0;i<3;i++){
            System.out.printf("write modities\n");
            pricesInfo.setPrice(Math.random()*10, Math.random()*8);
            System.out.println("has modities");
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
