
package Attendance;

import java.util.ArrayList;


public class AttendanceList {
    
    public final int LectureId;
    public int weeks ;
    private Attendance next = null ;
    
    public AttendanceList ( int lectureId){
        this. LectureId = lectureId ;
        this . weeks = 0 ;
    }
    
    public boolean addAttendance(int week,int status){
        boolean flag ;
        if(next == null) 
        {
            Attendance New = new Attendance(week,status);
            next = New ;
            flag = true ;
        }
        else {
            flag = next . addAttendance(week , status) ;  
        }
        if(flag){
            this.weeks ++ ;
            return true ;
        }
        else
            return false ;
    }
    
    public boolean isLecture(int lectureId){
        return (this.LectureId == lectureId) ;
    }
    
    public boolean haveWeek(int week){
        return this.weeks >= week ;
    }
    
    public boolean isDay (int day){
        return (this.LectureId%100)/10 == day ;
    }
    
    public boolean markAttendance(int week ,int status){
        if ( next == null) 
            return false ;
        else
        return next.mark(week, status) ;
    }
    
    
    public  boolean query(ArrayList<AttendanceQuery> queryList ){
        queryList = new ArrayList<> ();
        int p = this . next . query(queryList) ;
        return (p*100)/weeks >= 60 ;
    }
    
    public boolean checkDay(int day){
        return (this.LectureId % 10 == day) ;
    }
    
    public int dailyReport(int week){
        if (this.next != null)
            return this.next.dailyReport(week) ;
        else
            return 0 ;
    }
    
    public int monthlyReport(int month){
        if (this.next != null)
            return this.next.monthlyReport(month) ;
        else
            return 0 ;
    }
    
    public int report(){
        if (this.next != null)
            return this.next.report() ;
        else 
            return 0 ;
    }
}
