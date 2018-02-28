package java7_5.chapter2;

import java.util.List;
import java.util.concurrent.RecursiveAction;

public class Task extends RecursiveAction {

    private static final long serialVersionUID = -2775291073670137364L;
    private List<Product> productList;
    private int first;
    private int last;
    private double increment;

    public Task(List<Product> productList, int first, int last, double increment) {
        this.productList = productList;
        this.first = first;
        this.last = last;
        this.increment = increment;
    }

    @Override
    protected void compute() {
        if(last-first<10){
            updatePrices();
        }else{
            int middle=(last+first)/2;
            System.out.printf("task pending task:%s\n",getQueuedTaskCount());
            Task task1=new Task(productList,first,middle,increment);
            Task task2=new Task(productList,middle,last,increment);
            invokeAll(task1,task2);
        }
    }

    private void updatePrices() {
        for(int i=first;i<last;i++){
            Product product=productList.get(i);
            product.setPrice(product.getPrice()*(1+increment));
        }
    }
}
