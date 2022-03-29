package attendencemanagmentsystem;


public class Fees {
    String name ;
    int studentId ;
    boolean fees ;

    public Fees(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    public Fees(int studentId, boolean fees) {
        this.studentId = studentId;
        this.fees = fees;
    }
    
    
}
