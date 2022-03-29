package attendencemanagmentsystem;

import Attendance.AttendanceList;
import Attendance.Query ;
import Attendance.AttendanceQuery;
import java.io.Serializable;
import java.util.ArrayList;


public class Student extends User implements Serializable{
    
    private final String studentFileName = "Students.bin";

    public static ArrayList<Student> Students = new ArrayList<Student>();
    
    public boolean fees ;
    
    ArrayList<AttendanceList> studentAttendance = new ArrayList<AttendanceList>();
    
    public Student() {

    }

    public Student(String eMail, String fname, String lname) {
        super(eMail, "PassWord", fname, lname);
    }

    
    
    public boolean addStudent() {
        loadFromFile();
        this.setID(getNewId());
        System.out.println("this . id is : "+this.getID());
        Students.add(this);
        return commitToFile();
    }
    
    private int getNewId(){
        if(Students.isEmpty())
            return 2017001 ;
        else 
            return Students.get(Students.size()-1).id + 1 ;
    }
    
    public boolean commitToFile() {
        return FManger.write(studentFileName, Students);
    }

    public void loadFromFile() {
        Students = (ArrayList<Student>) FManger.read(studentFileName);
    }
    
    @Override
    public boolean login(int id ,String Pass){
        loadFromFile();
        int idx = getStudentIndex(id);
        if(id != -1){
            Student s = Students.get(idx) ;
            return s.chekLogin(id,pass);
        }
        return false ;
    }

    private int getStudentIndex(int id) {
        int sz = Students.size() ;
        for (int i = 0; i < sz; i++) {
            if (Students.get(i).getID() == id) {
                return i;
            }
        }

        return -1;
    }

    public void displayAllStudents() {
        loadFromFile();
    }

    public boolean updateStudent(int oldID) {
        loadFromFile();
        int index = getStudentIndex(oldID);

        if (index != -1) {
            Students.set(index, this);

            return commitToFile();
        }

        return false;
    }
    
    public Student searchStudent(int id){
        loadFromFile();
        int idx = getStudentIndex(id) ;
        if(idx != -1)
            return Students.get(idx) ;
        else
            return null ;
    }

    public boolean deleteStudent(int id) {
        loadFromFile();
        int index = getStudentIndex(id);

        if (index != -1) {
            Students.remove(index);

            return commitToFile();
        }

        return false;
    }
    
    public boolean isPaid(int id){
        loadFromFile();
        int idx = getStudentIndex(id);
        return Students.get(idx).fees ;
    }
    
    public void pay(int id){
        loadFromFile();
        int idx = getStudentIndex(id);
        Students.get(idx).fees = true ;
        commitToFile();
    }
    
    public void unPay(int id){
        loadFromFile();
        int idx = getStudentIndex(id);
        Students.get(idx).fees = false ;
        commitToFile();
    }
    
    public void markFees(int id){
        int idx = getStudentIndex(id);
        Students.get(idx).fees = true ;
    }
    
    public void unMarkFees(int id){
        int idx = getStudentIndex(id);
        Students.get(idx).fees = false ;
    }
    
    public boolean addLecture(int StudentId ,int lecId){
        loadFromFile();
        AttendanceList Att = new AttendanceList(lecId) ;
        int idx = getStudentIndex(StudentId) ;
        if(idx != -1){
            Students . get(idx) . studentAttendance .add(Att) ;
            return commitToFile();
        }
        return false ;
    }
    
    private int getLectureIdx(int studIdx ,int lecId){
        Student s = Students.get(studIdx) ;
        int sz = s.studentAttendance.size() ;
        for(int i=0 ; i<sz ;i++){
            if(s.studentAttendance.get(i).isLecture(lecId))
                return i ;
        }
        return -1 ;
    }
    
    private int getLectureIdx(int lecId){
        int sz = this.studentAttendance.size() ;
        for(int i=0 ; i<sz ;i++){
            if(this.studentAttendance.get(i).isLecture(lecId))
                return i ;
        }
        return -1 ;
    }
    
    public boolean removeLecture(int StudentId , int lecId){
        loadFromFile();
        int StuIdx = getStudentIndex(StudentId) ;
        if(StuIdx != -1){
            int lecIdx = getLectureIdx(StuIdx , lecId) ;
            Students.get(StuIdx).studentAttendance.remove(lecIdx);
            return commitToFile();
        }
        return false ;
    }
    
    public boolean addAttendance(int stuId ,int lectureId ,int week ,int status){
        int stuIdx = getStudentIndex(stuId) ;
        if(stuIdx != -1){
            int lecIdx = getLectureIdx(stuIdx, stuId) ;
            if(lecIdx != -1)
                return Students.get(stuIdx).studentAttendance.get(lecIdx).addAttendance(week, status);
        }
        return false ;
    }
    
    public boolean markAttendance(int stuId ,int lectureId ,int week ,int status){
        int stuIdx = getStudentIndex(stuId) ;
        if(stuIdx != -1){
            int lecIdx = getLectureIdx(stuIdx, lectureId) ;
            if(lecIdx != -1)
                return Students.get(stuIdx).studentAttendance.get(lecIdx).markAttendance(week, status);
        }
        return false ;
    }
    
    public boolean makeRqu(int lectureId , int week,int status){
        int lecIdx = getLectureIdx(lectureId) ;
        if(lecIdx != -1)
            return this.studentAttendance.get(lecIdx).markAttendance(week, status);
        return false ;
    }
    
    public ArrayList<Report> dailyReport(int day , int week){
        ArrayList<Report> Re = new ArrayList<>();
        for(AttendanceList Att : this.studentAttendance){
            if(Att.isDay(day) && Att.haveWeek(week)){
                Report r = new Report(Att.LectureId, Att.dailyReport(week));
                Re . add(r);
            }
        }
        return Re ;
    }
    
    public ArrayList<Report> monthlyReport(int month){
        ArrayList<Report> Re = new ArrayList<>();
        for(AttendanceList Att : this.studentAttendance){
            Report r = new Report(Att.LectureId, Att.monthlyReport(month));
                Re . add(r);
        }
        return Re ;
    }
    
    public ArrayList<Report> weeklyReport (int id ,int week){
        ArrayList<Report> Re = new ArrayList<>();
        loadFromFile();
        int idx = getStudentIndex(id) ;
        if(idx != -1){
            Student S = Students.get(idx) ;
            for(AttendanceList Att : S.studentAttendance){
                Report r = new Report(Att.LectureId, Att.dailyReport(week));
                    Re . add(r);
            }
        }
        return Re ;
    }
    
    public ArrayList<Report> report(int id){
        ArrayList<Report> Re = new ArrayList<>();
        loadFromFile();
        int idx = getStudentIndex(id) ;
        if(idx != -1){
            Student S = Students.get(idx) ;
            for(AttendanceList Att : S.studentAttendance){
                Report r = new Report(Att.LectureId, Att.report());
                    Re . add(r);
            }
        }
        return Re ;
    }
    
    public ArrayList<Report> myWeeklyReport(int week){
        return weeklyReport(this.id, week);
    }
    
    public ArrayList<Report> myReport(int week){
        return report(this.id);
    }
    
    public ArrayList<Fees> studentNotPaid(){
        loadFromFile();
        ArrayList<Fees> Fee = new ArrayList<>() ;
        for(Student s : Students){
            if(!s.fees){
                Fees f = new Fees(s.getFName()+" "+s.getLName(),s.getID()) ;
                Fee.add(f) ;
            }
        }
        return Fee ;
    }
    
    private Query haveLec(int lecId){
        Query q = null ;
        for(AttendanceList lec : this.studentAttendance){
            if(lec.LectureId == lecId){
                ArrayList<AttendanceQuery> queryList = new ArrayList<>();
                q = new Query(this.id,this.getLName(),lec.query(queryList)) ;
                break;
            }
        }
        return q ;
    }
    
    public ArrayList<Query> Query(int lecId){
        ArrayList<Query> Q = new ArrayList<>();
        loadFromFile();
        for (Student s : Students){
            Query q = s.haveLec(lecId);
            if(q != null)
                Q.add(q);
        }
        return Q ;
    }
}
