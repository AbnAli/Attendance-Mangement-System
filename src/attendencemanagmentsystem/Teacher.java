package attendencemanagmentsystem;

//import static attendencemanagmentsystem.Student.Students;
import Attendance.Query;
import java.io.Serializable;
import java.util.ArrayList;


public class Teacher extends User implements Serializable{
    private final String TeacherFileName = "Teacher.bin";

    public static ArrayList<Teacher> Teacheres = new ArrayList<Teacher>() ;
    
    public ArrayList<Integer> LecId = new ArrayList<>() ;
    
    public ArrayList<Integer> CourseId = new ArrayList<>() ;

    public Teacher() {
        
    }

    public Teacher(String eMail, String fname, String lname) {
        super(eMail, "TA_PassWord", fname, lname);
    }

    
    public boolean addTeacher() {
        loadFromFile();
        this.setID(getNewId());
        Teacheres.add(this);
        return commitToFile();
    }

    private int getNewId(){
        if(Teacheres.isEmpty())
            return 2001 ;
        else 
            return Teacheres.get(Teacheres.size()-1).id + 1 ;
    }
    
    @Override
    public boolean login(int id ,String Pass){
        loadFromFile();
        int idx = getTAIndex(id);
        if(id != -1){
            Teacher TA = Teacheres.get(idx) ;
            return TA.chekLogin(id,pass);
        }
        return false ;
    }
    
    public boolean commitToFile() {
        return FManger.write(TeacherFileName, Teacheres);
    }

    public void loadFromFile() {
        Teacheres = (ArrayList<Teacher>) FManger.read(TeacherFileName);
    }

    private int getTAIndex(int id) {
        for (int i = 0; i < Teacheres.size(); i++) {
            if (Teacheres.get(i).getID() == id) {
                return i;
            }
        }

        return -1;
    }

    public boolean updateTeacher(int id) {
        loadFromFile();
        int index = getTAIndex(id);

        if (index != -1) {
            Teacheres.set(index, this);

            return commitToFile();
        }

        return false;
    }

    public boolean deleteTeacher(int id) {
        loadFromFile();
        int index = getTAIndex(id);

        if (index != -1) {
            Teacheres.remove(index);

            return commitToFile();
        }

        return false;
    }
    
    public Teacher searchTeacher(int id){
        loadFromFile();
        int idx = getTAIndex(id) ;
        if(idx != -1)
            return Teacheres.get(idx) ;
        else
            return null ;
    }
    
    public void displayAllTeachers() {
        loadFromFile();
    }
    
    public boolean haveTime(int lecId){
        for(int x : LecId){
            if (lecId%100 == x%100)
                return false ;
        }
        return true ;
    }
    
    public boolean findCourse(int courseId){
        for(int c : CourseId){
            if ( courseId == c)
                return true ;
        }
        return false ;
    }
    
    private void addCourse(int courseId){
        if ( !findCourse(courseId)){
            CourseId.add(courseId);
        }
    }
    
    public boolean findLecCourse(int courseId){
        for(int l : LecId){
            if (l/100 == courseId)
                return true ;
        }
        return false ;
    }
    
     private int getCourseIdx(int id) {
        for (int i = 0; i < CourseId.size(); i++) {
            if (CourseId.get(i) == id) {
                return i;
            }
        }

        return -1;
    }
    
    private void removeCourse(int courseId){
        if( !findLecCourse(courseId))
            CourseId.remove(getCourseIdx(courseId)) ;
    }
    
    public boolean addLecture(int lecId ,int taId){
        loadFromFile();
        int idx = getTAIndex(taId) ;
        if(idx != -1){
            Teacher TA = Teacheres.get(idx) ;
            if (TA.haveTime(lecId)){
                TA.LecId.add(lecId) ;
                TA.addCourse(lecId/100);
                return commitToFile() ;
            }
        }
        return false ;
    }
    
    public boolean removeLecture(int lecId,int taId){
        loadFromFile();
        int idx = getTAIndex(taId) ;
        if(idx != -1){
            Teacher TA = Teacheres.get(idx) ;
            int lecIdx = TA.getLecIdIdx(lecId);
            if(lecIdx != -1){
                TA.LecId.remove(lecIdx) ;
                return commitToFile() ;
            }
        }
        return false ;
    }
    
    private int getLecIdIdx(int id) {
        for (int i = 0; i < LecId.size(); i++) {
            if (LecId.get(i) == id) {
                return i;
            }
        }

        return -1;
    }

    
    public ArrayList<Integer> handover(int lecId){
        loadFromFile();
        ArrayList<Integer> TA = new ArrayList<>();
        for(Teacher t : Teacheres){
            if(t.haveTime(lecId))
                TA.add(t.getID());
                
        }
        return TA ;
    }
    
    private boolean addLectureTo(int TaId, int lecId){
        loadFromFile();
        int idx = getTAIndex(TaId) ;
        if(idx != -1){
            Teacher TA = Teacheres.get(idx) ;
            TA.LecId.add(lecId) ;
            TA.addCourse(lecId/100);
        }
        return false ;
    }
    
    private boolean removeMyLecture(int lecId){
        int idx = getLecIdIdx(lecId) ;
        if(idx != -1){
            this.LecId.remove(idx) ;
            return true ;
        }
        return false ;
    }
    
    public boolean handoverTo(int TAId , int lecId ){
        int t = getTAIndex(TAId) ;
        if(t != -1){
            if(this.addLectureTo(TAId ,lecId)){ ;
                if(this.removeMyLecture(lecId)) ;
                    return commitToFile() ;
            }
        }
        return false ;
    }
    
    public ArrayList<Fees> studentNotPaidFees(){
        Student x = new Student() ;
        return x.studentNotPaid() ;
    }
    
    public boolean deleteStudent(int StudentId){
        Student s = new Student();
        if(s.isPaid(StudentId))
            return s.deleteStudent(StudentId) ;
        return false ;
    }
    
    public ArrayList<Integer> getMyLectures (){
        return this . LecId ;
    }
    
    public boolean markStudentAttendance(int stuId, int lecId, int week, int status){
        Student x = new Student();
        return x.markAttendance(stuId, lecId, week, status);
    }
    
    public ArrayList<Query> studentAtLec(int lecId){
        Student x = new Student();
        return x.Query(lecId);
    }
}
