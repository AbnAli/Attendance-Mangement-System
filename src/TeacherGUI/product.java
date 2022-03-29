package TeacherGUI;

public class product {
    
    
    private String name;
    private int id;
   
    /**
     *
     */
    public void product(){
        this.name= "";
        this.id = 0;
        }
    
    
     public product(String name , Integer id){
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
