package data;
import java.io.*;
import java.util.*;
import business.Module;

public class FileModule {
    
    public ArrayList<Module> readFile() {
        File myObj=new File("d:\\hd50\\module.txt");
        ArrayList<Module>mList=new ArrayList<>();
        
        try{
              Scanner sc=new Scanner(myObj);
              
              while(sc.hasNextLine()){
                  
                  String line=sc.nextLine();
                  String[] md=line.split(" ");
                  int moduleID=Integer.valueOf(md[0]);
                  String mTitile=md[1];
                  Module m=new Module(moduleID, mTitile);
                  
                  mList.add(m);
              }
              sc.close();
              return mList;
              
          }catch(Exception e){
            e.printStackTrace();
            return mList;
        
            }     
        }
}
