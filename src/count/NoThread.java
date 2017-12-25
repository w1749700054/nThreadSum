package count;

public class NoThread {
    public static void main(String[] args) {
        int sum=0;
        for(int i=0;i<50000;i++){
            sum+=i;
        }
        System.out.println(sum);
    }
}
