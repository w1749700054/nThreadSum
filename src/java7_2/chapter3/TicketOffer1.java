package java7_2.chapter3;

public class TicketOffer1 implements Runnable {
    private Cinema cinema;

    public TicketOffer1(Cinema cinema) {
        this.cinema = cinema;
    }

    @Override
    public void run() {
        cinema.sellTicket1(3);
        cinema.sellTicket1(2);
        cinema.sellTicket1(2);
        cinema.returnTicket1(3);
        cinema.sellTicket1(5);
        cinema.sellTicket2(2);
        cinema.sellTicket2(2);
        cinema.sellTicket2(2);
    }
}
