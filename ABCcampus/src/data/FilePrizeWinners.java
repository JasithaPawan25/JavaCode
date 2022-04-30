
package data;
import java.io.*;
import java.util.*;
import business.Result;


public class FilePrizeWinners {
     public void writeFile(String line) {
        try{
            FileWriter writer=new FileWriter("d:\\hd50\\prizewinners.txt",true);
            writer.write(line);
            writer.close();
            } catch(IOException e){
            
                e.printStackTrace();
            }
               
    }
}
