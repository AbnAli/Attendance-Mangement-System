package attendencemanagmentsystem;

import java.util.ArrayList;


public class Admin extends User{
    
    public Admin(){
        super("admin@gmail.com","123456789","Abmed","Mo");
        this.id = 1000 ;
    }
   
    public boolean addStudent(String eMail,String fname,String lname){
        Student x = new Student(eMail,fname,lname);
        return x . addStudent() ;
    }
    
    public boolean deleteStudent(int StudentId){
         Student x = new Student();
         return x.deleteStudent(StudentId);
     }
    
    public Student searchForStudent(int id) {
        Student x = new Student();
        return x.searchStudent(id);
    }
    
    public void displayAllStudentes (){
        Student x = new Student() ;
        x.displayAllStudents();
    }
    
    public boolean updateStudentData(int id,String eMail,String fname,String lname){
        Student x = new Student(eMail,fname,lname) ;
        x.setID(id);
        return x.updateStudent(id) ;
    }
    
    public ArrayList<Report> weeklyReport(int studentId,int week){
        Student x = new Student();
        return x.weeklyReport(studentId, week);
    }
    
    public ArrayList<Report> report(int studentId){
        Student x = new Student();
        return x.report(studentId);
    }
    
    public boolean addLectureToStudent(int studentId ,int lecId){
        Student x = new Student();
        return x.addLecture(studentId, lecId);
    }
    
    public boolean removeLectureFromStudent(int studentId ,int lecId){
        Student x = new Student();
        return x.removeLecture(studentId, lecId);
    }
    
    
    
    public boolean addTeacher(String name,String phone,String email){
        Teacher x = new Teacher(name ,phone,email);
        return x . addTeacher() ;
    }
    
    public boolean deleteTeacher(int id){
        Teacher x = new Teacher();
        return x.deleteTeacher(id);
        
    }
    
    public boolean updateTeacherData(int id,String eMail,String fname,String lname){
        Teacher x = new Teacher(eMail,fname,lname) ;
        x.setID(id);
        return x.updateTeacher(id) ;
    }
    
    public Teacher searchForTeacher (int id){
        Teacher TA = new Teacher() ;
        TA = TA.searchTeacher(id) ;
        return TA ;
    }
    
    public void displayAllTeachers(){
        Teacher TA = new Teacher() ;
        TA.displayAllTeachers() ;
    }
    
}
