package user;
import java.util.*;
import java.io.*;
import business.Module;
import business.Result;
import business.IntStudent;
import business.LocalStudent;
import business.Student;
import data.FilieResult;
import data.FileModule;
import data.FileStudent;
import data.FilePrizeWinners;
import data.*;
import business.*;



public class Main {
    
    public static void main(String[] args) {
        FileModule fm=new FileModule();       // object creation
        FilieResult fr=new FilieResult();
        FileStudent fs=new FileStudent();
        FilePrizeWinners fp=new FilePrizeWinners();
        Scanner sc=new Scanner(System.in);
        String ans="yes";
        
        String user,pass;
        
        System.out.println("============Welcome to ABC campus===================");
        
        
        System.out.println("***************************************************");
        System.out.println("Enter your user name");
        user=sc.nextLine();
        
        System.out.println("Enter your password");
        pass=sc.nextLine();
        
        System.out.println("***************************************************");
        
        if(user.equals("icbt") && (pass.equals("123"))){

            System.out.println("=======Student details about short computing course in Business Management===========");    
            
        while(ans.equals("yes")){
    

       
       String line="\nSystem options:"+System.lineSeparator();
		    line=line+"1:Module list"+System.lineSeparator();
		    line=line+"2:Student list"+System.lineSeparator();
		    line=line+"3:Add Result"+System.lineSeparator();
		    line=line+"4:Get Result"+System.lineSeparator();
		    line=line+"5:Module 1 top student"+System.lineSeparator();
                    line=line+"6:Module 2 top student"+System.lineSeparator();
                    line=line+"7:Student Average Marks"+System.lineSeparator();
                    line=line+"8:Best 3 Student of the Course"+System.lineSeparator();
                    line=line+"9:Prize Winners"+System.lineSeparator();
                    line=line+"10:Help"+System.lineSeparator();
                    line=line+"11:Exit"+System.lineSeparator();
                    
			System.out.println(line);
			System.out.println("Your Option:");
			int option=0;
             try {
                 option=sc.nextInt();
                }catch(InputMismatchException e){
                        System.out.println("Invalid Option");
                        System.exit(0);
                }
       
        switch(option){
            
            case 1:
                System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                System.out.println("Available Modules");
                getModules(fm);
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                break;
                
            case 2:
                System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                System.out.println("Student list");
                getStudent(fs);
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                break;
                               
                
            case 3:
                System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                System.out.println("Add Student Results");
                addResult(sc,fr);
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                break;
                
            case 4:
                System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                System.out.println("Student Result\n");
                System.out.println("StID FName LName BatN M1 M2");
                getResults(fr);
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                break;
                
            case 5:
                System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                System.out.println("Module 1 top student:-");
                System.out.println("StID FName LName BatN M1 M2");
                getTopMarksMI(fr);
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                break;
                
            case 6:
                System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                System.out.println("\nModule 2 top student:-\n");
                System.out.println("StID FName LName BatN M1 M2");
                getTopMarksMII(fr);
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                break;
                
            case 7:
                System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                System.out.println("Student Average Marks\n");
                System.out.println("StID FName LName BatN Avg");
                getAvgMarks(fr);
                 System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                break;
                
            case 8:
                System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                System.out.println("Best 3 students of the Course\n");
                System.out.println("StID FName LName M1 M2 Avg");
                top3Students(fr);
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                break;
                
            case 9:
                System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                System.out.println("Prize Winners");
                 System.out.println("\nTop Student in Module 1"); 
                 writeTopMarksMI(fr);
                 System.out.println("\nTop Student in Module 2"); 
                writeTopMarksMII(fr);
                System.out.println("\nTop 3 Student in course"); 
                writetop3Students(fr);
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                break;
                
            case 10:
                System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                System.out.println("Help");
                System.out.println("You can login to the system using Special name and campus own passward."
                                    + "\nIf you update the student results be responsible for fill all the details.");
                                    
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                break;
                
            case 11:
                System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                System.out.println("ThankYou for using ABC campus app");
                System.exit(0);
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                break;               
                
            default:
                System.out.println("Input option is incorrect. Please try again");
                System.exit(0);
            
        }
        
        System.out.println("\n * Do you want to continue? (yes/no)");
        ans=sc.next();

        }
        
        
       } else{
            System.out.println("Error. Wrong Password/Username. Please try again");
        }
        
        
    }
    
    
    
    
    private static void getModules(FileModule fm) {
        
        
        ArrayList<Module>mList=fm.readFile();
        
        for(Module m:mList){
                System.out.println(m.getModuleID()+" "+m.getmTiltle());
                
            }
        }
    
    
    
    private static void getResults(FilieResult fr){
        
        ArrayList<Result>rList=fr.readFile();
        
            for(Result r:rList){
             
                System.out.println(r.getStudentID()+" "+r.getFirstName()+" "+r.getLastName()+" "+r.getBatchID()+" "+r.getmMarks1()+" "+r.getmMarks2());
            }
        
        
        
    }
    
    private static void getTopMarksMI(FilieResult fr){
        ArrayList<Result>rList=fr.readFile();
        
        Result rMax=null;
        int max=0;

        for(Result r:rList){
            int marks1=r.getmMarks1();
            if(marks1>max){
                rMax=r;
                max=rMax.getmMarks1();
                }
    }
          
        System.out.println(rMax.getStudentID()+" "+rMax.getFirstName()+" "+rMax.getLastName()+" "+rMax.getBatchID()+" "+rMax.getmMarks1()+" "+rMax.getmMarks2());
       
    }
    
    
      private static void writeTopMarksMI(FilieResult fr){
        ArrayList<Result>rList=fr.readFile();
        
        Result rMax=null;
        int max=0;

        for(Result r:rList){
            int marks1=r.getmMarks1();
            if(marks1>max){
                rMax=r;
                max=rMax.getmMarks1();
                }
    }
          
        System.out.println(rMax.getStudentID()+" "+rMax.getFirstName()+" "+rMax.getLastName()+" "+rMax.getBatchID()+" "+rMax.getmMarks1()+" "+rMax.getmMarks2());
             FilePrizeWinners writ=new FilePrizeWinners();
            writ.writeFile("Top Marks Module 1:- " +rMax.getFirstName()+" "+rMax.getLastName());
    }  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     private static void getTopMarksMII(FilieResult fr){
        ArrayList<Result>rList=fr.readFile();
        
        Result rMax=null;
        int max=0;

        for(Result r:rList){
            int marks1=r.getmMarks2();
            if(marks1>max){
                rMax=r;
                max=rMax.getmMarks2();
                }
    }
          
        System.out.println(rMax.getStudentID()+" "+rMax.getFirstName()+" "+rMax.getLastName()+" "+rMax.getBatchID()+" "+rMax.getmMarks1()+" "+rMax.getmMarks2());
        
    
    }
    
     
          private static void writeTopMarksMII(FilieResult fr){
        ArrayList<Result>rList=fr.readFile();
        
        Result rMax=null;
        int max=0;

        for(Result r:rList){
            int marks1=r.getmMarks2();
            if(marks1>max){
                rMax=r;
                max=rMax.getmMarks2();
                }
    }
          
        System.out.println(rMax.getStudentID()+" "+rMax.getFirstName()+" "+rMax.getLastName()+" "+rMax.getBatchID()+" "+rMax.getmMarks1()+" "+rMax.getmMarks2());
             FilePrizeWinners writ=new FilePrizeWinners();
            writ.writeFile("\nTop Marks Module 2:- " +rMax.getFirstName()+" "+rMax.getLastName()+"\n\n");
    
    }
     
     
     
     
     
     
     
     
     
     
     
     
     
     	private static void getAvgMarks(FilieResult fr) {
		ArrayList<Result>rList=fr.readFile();
                double avg=0;
		int total=0;
		for(Result r: rList) {
			total=r.getmMarks1()+r.getmMarks2();
		
                avg= total/2;
                
		System.out.println(r.getStudentID()+" "+r.getFirstName()+" "+r.getLastName()+" "+r.getBatchID()+" "+avg);
                
                }
		
	}
     
        
        private static void top3Students(FilieResult fr){
            ArrayList<Result>rList=fr.readFile();
            int first=0;
            String firstStudent=null;
            int second=0;
            String secondStudent=null;
            int third=0;
            String thirdStudent=null;
            
            for(Result r:rList){
                int total=r.getmMarks1()+r.getmMarks2();
                int avg = total/2;
                if(avg>first){
                    third=second;
                    thirdStudent=secondStudent;
                    second=first;
                    secondStudent=firstStudent;
                    first=avg;
                    firstStudent=r.getStudentID()+" "+ r.getFirstName()+" "+r.getLastName()+" "+r.getmMarks1()+" "+r.getmMarks2();
                }else if(avg>second){
                    third=second;
                    thirdStudent=secondStudent;
                    second=avg;
                    secondStudent=r.getStudentID()+" "+ r.getFirstName()+" "+r.getLastName()+" "+r.getmMarks1()+" "+r.getmMarks2();
                }else if(avg>third){
                    third=avg;
                    thirdStudent=r.getStudentID()+" "+ r.getFirstName()+" "+r.getLastName()+" "+r.getmMarks1()+" "+r.getmMarks2();
               
                }
                
                    
                
            }
            
            
                String line=firstStudent+" "+first+System.lineSeparator();
		line=line+secondStudent+" "+second+System.lineSeparator();
		line=line+thirdStudent+" "+third+System.lineSeparator();
		System.out.println(line);
            
                    
       
        }
        
        
              private static void writetop3Students(FilieResult fr){
            ArrayList<Result>rList=fr.readFile();
            int first=0;
            String firstStudent=null;
            int second=0;
            String secondStudent=null;
            int third=0;
            String thirdStudent=null;
            
            for(Result r:rList){
                int total=r.getmMarks1()+r.getmMarks2();
                int avg = total/2;
                if(avg>first){
                    third=second;
                    thirdStudent=secondStudent;
                    second=first;
                    secondStudent=firstStudent;
                    first=avg;
                    firstStudent=r.getStudentID()+" "+ r.getFirstName()+" "+r.getLastName()+" "+r.getmMarks1()+" "+r.getmMarks2();
                }else if(avg>second){
                    third=second;
                    thirdStudent=secondStudent;
                    second=avg;
                    secondStudent=r.getStudentID()+" "+ r.getFirstName()+" "+r.getLastName()+" "+r.getmMarks1()+" "+r.getmMarks2();
                }else if(avg>third){
                    third=avg;
                    thirdStudent=r.getStudentID()+" "+ r.getFirstName()+" "+r.getLastName()+" "+r.getmMarks1()+" "+r.getmMarks2();
               
                }
                
                    
                
            }
            
            
                String line=firstStudent+" "+first+System.lineSeparator();
		line=line+secondStudent+" "+second+System.lineSeparator();
		line=line+thirdStudent+" "+third+System.lineSeparator();
		System.out.println(line);
            
                    
            FilePrizeWinners writ=new FilePrizeWinners();
            writ.writeFile(line);
        }
        
        
        
        
        
        
        
    public static void prizeWinners (FilePrizeWinners fp) {
         File myObj=new File("d:\\hd50\\prizewinners.txt");
        try{
            Scanner sc=new Scanner(myObj);
            while(sc.hasNextLine()){
                String line=sc.nextLine();
                System.out.println(line);
            }
            sc.close();
            
        }catch(FileNotFoundException ex){
            System.out.println("Unable to Read");
        }
        
    }
        
    
    private static void addResult(Scanner sc, FilieResult fr) {
		ArrayList<Result> rList=new ArrayList<>();
		String ans="yes";
		while(ans.equals("yes")) {
		 System.out.println("Enter the StudentID");
		 int stdID=sc.nextInt();
		
                 System.out.println("Enter Fname");
                 String FirstName=sc.next();
                 
                 System.out.println("Enter Lname");
                 String LastName=sc.next();
                 
                 System.out.println("Enter BID");
                 int BatchID=sc.nextInt();
                 
                 System.out.println("Enter M1");
                 int Marks1=sc.nextInt();
                 
		 System.out.println("Enter M2");
		 int Marks2 =sc.nextInt();
		
		
		 Result r=new Result(stdID, FirstName, LastName, BatchID, Marks1, Marks2);
		 rList.add(r);
		 System.out.println("Do you want to input more(yes/no)");
		 ans=sc.next();
		}
		
		fr.writeFile(rList);
                
                  }
                

    
    
	private static void getStudent(FileStudent fs) {
		ArrayList<Student> sList=fs.readFile();
		for(Student s: sList) {
        if(s instanceof LocalStudent) {
                LocalStudent loc=(LocalStudent)s;
                System.out.println(loc.getStudentID()+" "+loc.getBatchID()+" "+loc.getFirstName()+" "+loc.getLastName()+" "+loc.getNic());
        }else {
                IntStudent ints=(IntStudent)s;
                System.out.println(ints.getStudentID()+" "+ints.getBatchID()+" "+ints.getFirstName()+" "+ints.getLastName()+" "+ints.getPassport());
        }
		}
	}
              
              
        
    }
         
         