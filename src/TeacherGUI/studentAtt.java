package TeacherGUI;

public class studentAtt {
    String name;
    boolean ratio;
    boolean week1;
 
 
    boolean week2;
 
    boolean week3;
 
    boolean week4;
 
     public void studentAtt(){
        this.name= "";
        this.ratio = false;
        this.week1=false;
        this.week2=false;
        this.week3=false;
        this.week4=false;
        }
       public studentAtt(String name , boolean ratio,boolean week1,boolean week2,boolean week3,boolean week4){
        this.name = name;
        this.ratio = ratio;
        this.week1 = week1;
        this.week2 = week2;
        this.week3 = week3;
        this.week4 = week4;
     }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public void setRatio(boolean ratio) {
        this.ratio = ratio;
    }
 
    public void setWeek1(boolean week1) {
        this.week1 = week1;
    }
 
    public void setWeek2(boolean week2) {
        this.week2 = week2;
    }
 
    public void setWeek3(boolean week3) {
        this.week3 = week3;
    }
 
    public void setWeek4(boolean week4) {
        this.week4 = week4;
    }
 
    public String getName() {
        return name;
    }
 
    public boolean isRatio() {
        return ratio;
    }
 
    public boolean isWeek1() {
        return week1;
    }
 
    public boolean isWeek2() {
        return week2;
    }
 
    public boolean isWeek3() {
        return week3;
    }
 
    public boolean isWeek4() {
        return week4;
    }
}
