
package data;
import java.io.*;
import java.util.*;
import business.Result;


public class FilieResult{
      public ArrayList<Result> readFile() {
          
         File myObj=new File("d:\\hd50\\result.txt");
        ArrayList<Result>rList=new ArrayList<>();
        
        try{
              Scanner sc=new Scanner(myObj);
              
              while(sc.hasNextLine()){
                  
                  String line=sc.nextLine();
                  String[] md=line.split(" ");
                  int studentID=Integer.valueOf(md[0]);
                  String firstName=md[1];
                  String lastName=md[2];
                  int batchID=Integer.valueOf(md[3]);
                  int mMarks1=Integer.valueOf(md[4]);
                  int mMarks2=Integer.valueOf(md[5]);
                  
                  Result r=new Result(studentID, firstName, lastName, batchID, mMarks1, mMarks2);
                  
                  
                  rList.add(r);
              }
              sc.close();
              return rList;
              
          }catch(Exception e){
            e.printStackTrace();
            return rList;
        
            }
        
    }

    
	public boolean writeFile(ArrayList<Result>rList){
		
		try {
			FileWriter writer=new FileWriter("d:\\hd50\\result.txt",true);
			for(Result r:rList) {
				String line=r.getStudentID()+" "+r.getFirstName()+" "+r.getLastName()+" "+r.getBatchID()+" "
                                        +r.getmMarks1()+" "+r.getmMarks2()+System.lineSeparator();
				writer.write(line);
			}
			writer.close();			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
        }   
}

	