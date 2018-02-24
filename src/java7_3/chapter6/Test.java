package java7_3.chapter6;

import java.util.concurrent.Phaser;

public class Test {
    public static void main(String[] args) {
        Phaser phaser=new Phaser(3);
        FileSearch fileSystem=new FileSearch("C:\\Windows","log",phaser);
        FileSearch apps=new FileSearch("C:\\Program Files","log",phaser);
        FileSearch documents=new FileSearch("C:\\Document And Setting","log",phaser);
        Thread sysThread=new Thread(fileSystem,"System");
        sysThread.start();
        Thread appsThread=new Thread(apps,"apps");
    }
}
