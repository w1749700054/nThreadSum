package count.call;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

public class CountCall1 implements Callable<Integer> {
    private CountDownLatch countDownLatch;
    private int min,max;
    public CountCall1(CountDownLatch countDownLatch,int min, int max){
        this.countDownLatch=countDownLatch;
        this.max=max;
        this.min=min;
    }

    @Override
    public Integer call(){
        try {
            int partSum = 0;
            for (int i = min; i <max; i++) {
                partSum = partSum + i;
            }
            return partSum;
        }finally {
            countDownLatch.countDown();
        }
    }
}
