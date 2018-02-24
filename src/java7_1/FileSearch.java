package java7_1;

import java.io.File;

public class FileSearch implements Runnable {
    private String initPath;
    private String fileName;
    public FileSearch(String initPath,String fileName){
        this.initPath=initPath;
        this.fileName=fileName;
    }
    @Override
    public void run() {
        File file=new File(initPath);
        if(file.isDirectory()){
            try{
                directoryProcess(file);
            } catch (InterruptedException e) {
                System.out.printf("%s :the seach has bean interrupt",Thread.currentThread().getName());
            }
        }
    }

    private void directoryProcess(File file) throws InterruptedException {
        File[] files=file.listFiles();
        if(files!=null) {
            for (File f : files) {
                if(f.isDirectory()){
                    directoryProcess(f);
                }else{
                    fileProcess(f);
                }
            }
        }
        if(Thread.interrupted()){
            throw new InterruptedException();
        }
    }

    private void fileProcess(File file) throws InterruptedException {
        if(file.getName().equals(fileName)){
            System.out.printf("%s:%s\n",Thread.currentThread().getName(),file.getAbsoluteFile());
        }
        if(Thread.interrupted()){
            throw new InterruptedException();
        }
    }
}
