package java7_2.chapter2;

public class Account {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public synchronized void addAccount(double account){
        double temp=balance;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        temp+=account;
        balance=temp;
    }
    public synchronized void subAccount(double account){
        double temp=balance;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        temp-=account;
        balance=temp;
    }
}
