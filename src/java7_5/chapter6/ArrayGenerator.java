package java7_5.chapter6;

import java.util.Random;

public class ArrayGenerator {
    public int[] generatorArray(int size){
        int[] array=new int[size];
        Random random=new Random();
        for(int i=0;i<size;i++){
            array[i]=random.nextInt();
        }
        return array;
    }
}
