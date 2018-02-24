package java7_2.chapter2;

public class Company implements Runnable {
    private Account account;

    public Company(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for(int  i=0;i<100;i++){
            account.addAccount(1000);
        }
    }
}
