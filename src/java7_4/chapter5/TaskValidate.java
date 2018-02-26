package java7_4.chapter5;

import java.util.concurrent.Callable;

public class TaskValidate implements Callable<String> {
    private UserValidate validate;
    private String username;
    private String password;

    public TaskValidate(UserValidate validate, String username, String password) {
        this.validate = validate;
        this.username = username;
        this.password = password;
    }

    @Override
    public String call() throws Exception {
        if(!validate.validate(username,password)){
            System.out.printf("%s :the user has not bean find\n",validate.getName());
            throw new Exception("Error validate user");
        }
        System.out.printf("%s :the user has bean found\n",validate.getName());
        return validate.getName();
    }
}
