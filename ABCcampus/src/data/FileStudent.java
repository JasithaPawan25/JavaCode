
package data;
import java.io.*;
import java.util.*;
import business.*;

public class FileStudent{
      public ArrayList<Student> readFile() {
          
         File myObj=new File("d:\\hd50\\student.txt");
        ArrayList<Student>sList=new ArrayList<>();
        
        try{
	     Scanner sc=new Scanner(myObj);	
				
            while(sc.hasNextLine()) {

                    String line=sc.nextLine();
                    String[] std=line.split(" ");
                    int studentID=Integer.valueOf(std[0]);
                    int batchID=Integer.valueOf(std[1]);
                    String firstName=std[2];
                    String lastName=std[3];
                    if(!std[4].equals("na")) {
                            String nic=std[4];
                            LocalStudent ls=new LocalStudent(studentID, batchID, firstName, lastName, nic);
                            sList.add(ls);
                        }else {
                            String passport=std[5];
                            IntStudent is=new IntStudent(studentID, batchID, firstName, lastName, passport);
                            sList.add(is);
                    }					

                }
            sc.close();
            return sList;
						
              }
              catch(Exception e){
            e.printStackTrace();
            return sList;
        
              
              }
        }
        
         
    }

    
  

    

