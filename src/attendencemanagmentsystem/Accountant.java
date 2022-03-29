package attendencemanagmentsystem;

import java.util.ArrayList;


public class Accountant extends User{

    public Accountant() {
    }

    public Accountant(String user, String pass, int id) {
        super();
    }
    
    public void markPaid(int studentId){
        Student s = new Student() ;
        s . pay(studentId) ;
    }
    
    public void unMarkPaid(int studentId){
        Student s = new Student() ;
        s . unPay(studentId) ;
    }
    
    public boolean save(ArrayList <Fees> student){
        Student stu = new Student() ;
        stu.loadFromFile();
        for(Fees s : student){
            if(s.fees)
                stu.markFees(s.studentId); 
            else
                stu.unMarkFees(s.studentId);
        }
        
        return stu.commitToFile() ;
    }
}
