package java7_3.chapter6;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class FileSearch  implements Runnable{
    private String initPath;
    private String end;
    private List<String> results;
    private Phaser phaser;

    public FileSearch(String initPath, String end, Phaser phaser) {
        this.initPath = initPath;
        this.end = end;
        this.phaser = phaser;
        results=new ArrayList<>();
    }

    @Override
    public void run() {

    }
    private void directPrecess(File file){
        File[] listFile=file.listFiles();
        if(listFile!=null){
            for(File f:listFile){
                if(f.isDirectory()){
                    directPrecess(f);
                }else{
                    filePrecess(f);
                }
            }
        }
    }
    private void filePrecess(File file){
        if(file.getName().endsWith(end)){
            results.add(file.getAbsolutePath());
        }
    }
    private void fileResults(){
        List<String> newResults=new ArrayList<>();
        long actual=new Date().getTime();
        for(int i=0;i<results.size();i++){
            File file=new File(results.get(i));
            long fileDate=file.lastModified();
            if(actual-fileDate< TimeUnit.MILLISECONDS.convert(1,TimeUnit.DAYS)){
                newResults.add(results.get(i));
            }
        }
        results=newResults;
    }
}
