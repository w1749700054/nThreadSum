package java7_2.chapter3;

public class Test {
    public static void main(String[] args) {
        Cinema cinema=new Cinema();
        TicketOffer1 ticketOffer1=new TicketOffer1(cinema);
        TicketOffer2 ticketOffer2=new TicketOffer2(cinema);
        Thread offer1=new  Thread(ticketOffer1);
        Thread offer2=new Thread(ticketOffer2);
        offer1.start();
        offer2.start();
        try {
            offer1.join();
            offer2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("剩余的1票数是：%d\n",cinema.getVacanciesCinema1());
        System.out.printf("剩余的2票数是：%d\n",cinema.getVacaniesCinema2());
    }
}
