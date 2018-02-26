package java7_4.chapter5;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class UserValidate {
    private String name;

    public UserValidate(String name) {
        this.name = name;
    }
    public boolean validate(String username,String password){
        Random random=new Random();
        try {
            long duration= (long) (Math.random()*10);
            System.out.printf("validate %s:validating user during %d second\n", this.name,duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            return  false;
        }
        return random.nextBoolean();
    }

    public String getName() {
        return name;
    }
}
