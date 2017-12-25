package count.call;

import java.util.concurrent.*;

public class ChangeCount {
    private CountDownLatch countDownLatch;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
       ChangeCount cc=new ChangeCount();
       long start=System.currentTimeMillis();
       int count=cc.count(5,5,0,50000);
       long end=System.currentTimeMillis();
        System.out.println(count);
        System.out.println(end-start);
    }
    public int count(int mThread,int mFutrue,int min,int max) throws ExecutionException, InterruptedException {
        countDownLatch=new CountDownLatch(mFutrue);
        ExecutorService es= Executors.newFixedThreadPool(mThread);
        Future<Integer>[] futures=new Future[mFutrue];
        int dValue=(max-min)/mFutrue;
        for(int i=0;i<mFutrue;i++){
            if(i==mFutrue-1){
                futures[i]=es.submit(new CountCall1(countDownLatch,min,max));
            }else {
                futures[i] = es.submit(new CountCall1(countDownLatch, min, min = min + dValue));
            }
        }
        //改方法的运行时间约为10ms
        countDownLatch.await();
        int sum=0;
        for(int i=0;i<mFutrue;i++){
            sum=sum+futures[i].get();
        }
        return sum;
        //该方法约为50ms
//        es.shutdown();
//        while(true) {
//            if (es.isTerminated()) {
//                int sum=0;
//                for(int i=0;i<mFutrue;i++){
//                    sum=sum+futures[i].get();
//                }
//                return sum;
//            }
//        }
    }
}
