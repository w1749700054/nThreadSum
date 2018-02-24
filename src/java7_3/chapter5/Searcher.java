package java7_3.chapter5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Searcher implements Runnable {
    private int firstRow;
    private int lastRow;
    private MatrixMock mock;
    private Result result;
    private int number;
    private final CyclicBarrier barrier;

    public Searcher(int firstRow, int lastRow, MatrixMock mock, Result result, int number, CyclicBarrier barrier) {
        this.firstRow = firstRow;
        this.lastRow = lastRow;
        this.mock = mock;
        this.result = result;
        this.number = number;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        int count;
        System.out.printf("%s :Processing lines from %d to %d\n",Thread.currentThread().getName(),firstRow,lastRow);
        for(int i=firstRow;i<lastRow;i++){
            int[] row=mock.getRow(i);
            count=0;
            for(int j=0;j<row.length;j++){
                if(row[j]==number){
                    count++;
                }
            }
            result.setData(i,count);
        }
        System.out.printf("%s :line processing .\n",Thread.currentThread().getName());
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
