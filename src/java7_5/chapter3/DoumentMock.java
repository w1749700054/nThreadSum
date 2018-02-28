package java7_5.chapter3;

import java.util.Random;

public class DoumentMock {
    private String words[]={"the","hello","goodbye","packet","java","thread","pool","random","class","main"};
    public String[][] genertorDocument(int numLine,int numWords,String word){
        int count=0;
        String[][] documents=new String[numLine][numWords];
        Random random=new Random();
        for(int i=0;i<numLine;i++){
            for(int j=0;j<numWords;j++){
                int index=random.nextInt(words.length);
                documents[i][j]=words[index];
                if(documents[i][j].equals(word)){
                    count++;
                }
            }
        }
        System.out.println("the word appears "+count+" numbers");
        return documents;
    }
}
