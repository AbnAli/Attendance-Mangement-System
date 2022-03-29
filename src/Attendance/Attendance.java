
package Attendance;

import java.util.ArrayList;


/*
status values
1 yes
2 AC exption
3 not
4 request
5 exption
*/

public class Attendance {
    private int status ;
    private final int week ;
    private Attendance next = null ;
    
    public Attendance(int week  , int status ){
        this.status = status ;
        this.week = week ;
        
    }
    
    public boolean addAttendance(int week ,int status){
        if (this.week == week)
            return false ;
        if(next == null) 
        {
            Attendance New = new Attendance(week ,status);
            next = New ;
        }
        else {
            next . addAttendance(week, status) ;  
        }
        return true ;
    }
    
    public boolean mark(int week , int status){
        if(week == this.week){
            this.status = status ;
            return true ;
        }
        else if (next == null)
            return false ;
        else
            return next . mark(week , status) ;
    }
    
    
    
    public int query(ArrayList<AttendanceQuery> queryList){
        
        AttendanceQuery q = new AttendanceQuery(week ,status);
        queryList . add(q);
        
        if(next != null)
            this . next . query(queryList);
        
        if(status <= 2)
            return 1 ;
        else
            return 0 ;
    }
    
    public int dailyReport( int week){
        if(this.week == week )
            return this.status ;
        
        else if(this.next != null)
            return this.next.dailyReport(week);
        
        return 0 ;
    }
    
    public int monthlyReport(int month){
        int r ;
        if((this.week+3)/4 == month && this.status <= 2)
            r = 1 ;
        else
            r = 0 ;
        if(this.next != null && (this.week+3)/4 <= month)
            r = r + next.monthlyReport(month) ;
        return r ;
    }
    
    public int report(){
        int r ;
        
        if(this.status <= 2) 
            r = 1 ;
        else 
            r = 0 ;
        
        if(this.next != null) 
            r = r + this.next.report() ;
        
        return r ;
    }
}
