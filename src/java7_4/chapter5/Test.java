package java7_4.chapter5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        String username="test";
        String password="test";
        UserValidate ldapValidate=new UserValidate("Ldap");
        UserValidate dbValidate=new UserValidate("db");
        TaskValidate ldapTask=new TaskValidate(ldapValidate,username,password);
        TaskValidate dbTask=new TaskValidate(dbValidate,username,password);
        List<TaskValidate> list=new ArrayList<>();
        list.add(ldapTask);
        list.add(dbTask);

        ExecutorService es=Executors.newCachedThreadPool();
        String result;
        try{
            result=es.invokeAny(list);
            System.out.printf("Main:result %s\n",result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        es.shutdown();
        System.out.println("Main:the end");
    }
}
