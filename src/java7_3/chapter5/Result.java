package java7_3.chapter5;

public class Result {
    private int[] data;
    public Result(int size){
        data=new int[size];
    }
    public void setData(int  position,int value){
        data[position]=value;
    }

    public int[] getData() {
        return data;
    }
}
