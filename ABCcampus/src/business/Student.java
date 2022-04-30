
package business;


public abstract class Student { 
    private int studentID;
    private int batchID;
    private String firstName;
    private String lastName;

    public Student() {  // default constructor
        // TODO Auto-generated constructor stub  
    
    }

    public Student(int studentID, int batchID, String firstName, String lastName) { // default constructor
        this.studentID = studentID;
        this.batchID = batchID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // the above two constructors are examples for overloading(Polymorphisam)
    
    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getBatchID() {
        return batchID;
    }

    public void setBatchID(int batchID) {
        this.batchID = batchID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override   //Overriding is an exmple for polymorphisam
    public String toString() {
        // TODO Auto-generated constructor stub  
        String line=studentID+" "+batchID+" "+firstName+" "+lastName;
		return line; 
    }

  
    
}
