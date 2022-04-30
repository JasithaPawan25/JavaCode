
package business;


public class LocalStudent extends Student{ //this is examples for Inheritance
    private String nic;

    public LocalStudent() {
    }

    public LocalStudent(int studentID, int batchID, String firstName, String lastName,String nic) {
        super(studentID, batchID, firstName, lastName);
        this.nic = nic;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }
    
}
