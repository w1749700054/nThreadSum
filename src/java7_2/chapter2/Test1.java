package java7_2.chapter2;

public class Test1 {
    public static void main(String[] args) {
        Account account=new Account();
        account.setBalance(1000);
        Company company=new Company(account);
        Bank bank=new Bank(account);
        Thread companyThread=new Thread(company);
        Thread bankThread=new Thread(bank);
        System.out.printf("初始额度：%f",account.getBalance());
        companyThread.start();
        bankThread.start();
        try {
            companyThread.join();
            bankThread.join();
            System.out.printf("最后额度：%f",account.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
