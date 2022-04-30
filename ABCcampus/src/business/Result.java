
package business;

  // class 
public class Result {         
    private int studentID;
    private String firstName;
    private String lastName;
    private int batchID;
    private int mMarks1;
    private int mMarks2;

    public Result() {  // default constructor
    }

    public Result(int studentID, String firstName, String lastName, int batchID, int mMarks1, int mMarks2) {  // default constructor
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.batchID = batchID;
        this.mMarks1 = mMarks1;
        this.mMarks2 = mMarks2;
    }

    // the above two constructors are examples for overloading(Polymorphisam)
    
    
    public int getStudentID() { 
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
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

    public int getBatchID() {
        return batchID;
    }

    public void setBatchID(int batchID) {
        this.batchID = batchID;
    }

    public int getmMarks1() {
        return mMarks1;
    }

    public void setmMarks1(int mMarks1) {
        this.mMarks1 = mMarks1;
    }

    public int getmMarks2() {
        return mMarks2;
    }

    public void setmMarks2(int mMarks2) {
        this.mMarks2 = mMarks2;
    }

    @Override  //Overriding is an exmple for polymorphisam
    public String toString() {
        return "Result{" + "studentID=" + studentID + ", firstName=" + firstName + ", lastName=" + lastName + ", batchID=" + batchID + ", mMarks1=" + mMarks1 + ", mMarks2=" + mMarks2 + '}';
    }

   
    
}
