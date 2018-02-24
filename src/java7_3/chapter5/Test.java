package java7_3.chapter5;

import java.util.concurrent.CyclicBarrier;

public class Test {
    public static void main(String[] args) {
        final int ROWS=1000;
        final int NUMBER=1000;
        final int SEARCH=5;
        final int PARTICIPANT=5;
        final int LINE_PARTICIPANT=200;
        MatrixMock mock=new MatrixMock(ROWS,NUMBER,SEARCH);
        Result result=new Result(ROWS);
        Grouper grouper=new Grouper(result);
        CyclicBarrier cyclicBarrier=new CyclicBarrier(PARTICIPANT,grouper);
        Searcher[] searchers=new Searcher[PARTICIPANT];
        for(int i=0;i<PARTICIPANT;i++){
            searchers[i]=new Searcher(i*LINE_PARTICIPANT,(i*LINE_PARTICIPANT+LINE_PARTICIPANT),mock,result,5,cyclicBarrier);
            Thread thread=new Thread(searchers[i]);
            thread.start();
        }
        System.out.println("Main:the main thread  has finished\n");
    }
}
