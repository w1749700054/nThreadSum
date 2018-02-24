package java7_1;

public class PrimeGenerator extends Thread {
    @Override
    public void run() {
        long number=1l;
        while (true) {
            if (isPrime(number)) {
                System.out.printf("Number %d is prime\n", number);
            }
            if (isInterrupted()){
                System.out.printf("has bean interrupted\n");
                return;
            }
            number++;
        }
    }

    private boolean isPrime(long number) {
        if(number<=2){
            return true;
        }
        for(int i=2;i<number;i++){
            if(number%i==0){
                return false;
            }
        }
        return true;
    }
}
