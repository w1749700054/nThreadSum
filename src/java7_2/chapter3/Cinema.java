package java7_2.chapter3;

public class Cinema {
    private long vacanciesCinema1;
    private long vacaniesCinema2;
    private final Object controlCinema1,controlCinema2;
    public Cinema(){
        controlCinema1=new Object();
        controlCinema2=new Object();
        vacanciesCinema1=20;
        vacaniesCinema2=20;
    }
    public boolean sellTicket1(int number){
//        synchronized (controlCinema1){
            if(vacanciesCinema1>number){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                vacanciesCinema1-=number;
                return true;
            }else{
                return false;
            }
//        }
    }
    public boolean sellTicket2(int number){
//        synchronized (controlCinema2){
            if(number<vacaniesCinema2){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                vacaniesCinema2-=number;
                return true;
            }else{
                return false;
            }
//        }
    }
    public boolean returnTicket1(int number){
        synchronized (controlCinema1){
            vacanciesCinema1+=number;
            return true;
        }
    }
    public boolean returnTicket2(int number){
        synchronized (controlCinema2){
            vacaniesCinema2+=number;
            return true;
        }
    }

    public long getVacanciesCinema1() {
        return vacanciesCinema1;
    }

    public long getVacaniesCinema2() {
        return vacaniesCinema2;
    }
}
