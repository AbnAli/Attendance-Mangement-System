package TeacherGUI;



public class handoverTeacher {
     private String name;
    private int id;
   
    /**
     *
     */
    public void handoverTeacher(){
        this.name= "";
        this.id = 0;
        }
    
    
     public handoverTeacher(String name , Integer id){
        this.name = name;
        this.id = id;
     }
     
    public String getName(){
        return name;
    }

   
    public void setName(String name){
        this.name = name ;
    }
    
    
    
    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id ;
    }
    
    
    
     

}

