

package business;


public class IntStudent extends Student{  //this is examples for Inheritance
    private String passport;

    public IntStudent() {
    }

    public IntStudent(int studentID, int batchID, String firstName, String lastName,String passport) {
        super(studentID, batchID, firstName, lastName);
        this.passport = passport;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }


    
}
