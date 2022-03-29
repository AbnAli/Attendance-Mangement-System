package attendencemanagmentsystem;

public abstract class User {
    
    protected int id;
    protected String eMail;
    protected String pass;
    protected String fname;
    protected String lname;

    FileMangerBinary FManger = new FileMangerBinary();

    static MyException EX = new MyException("Attendance Exception");

    public User() {
    }

    public User(String eMail, String pass, String fname, String lname) {
        
        this.fname = fname;
        this.lname = lname;

        if (!eMail.contains("@") || !eMail.contains(".")) {
            this.eMail = EX.checkEmail("e-mail");
        } else {
            this.eMail = eMail;
        }

        if (pass.length() < 8) {
            this.pass = EX.checkPassLength("Password");
        } else {
            this.pass = pass;
        }

    }

    public void setID(int id) {
        this.id = id;
    }

    public void setFName(String fname) {
        this.fname = fname;
    }

    public void setLName(String lname) {
        this.lname = lname;
    }

    public void seteMail(String userName) {
       if (!eMail.contains("@") || !eMail.contains(".")) {
            this.eMail = EX.checkEmail("User name");
        } else {
            this.eMail = eMail;
        }
    }

    public void setPass(String pass ,String confirm ,String oldPass) {
        if (pass.length() < 8 && pass.equals(confirm) &&oldPass.equals(this.pass)) {
            this.pass = EX.checkPassLength("Password");
        } else {
            this.pass = pass;
        }
    }

    public String geteMail() {
        return this.eMail;
    }

    public String getPass() {
        return this.pass;
    }

    public int getID() {
        return this.id;
    }

    public String getFName() {
        return this.fname;
    }

    public String getLName() {
        return this.lname;
    }
    
    public String getName(){
        return this.fname + " " + this.lname ;
    }

    public boolean login(int id, String Pass) {
        if (this.id == id && Pass.equals(this.pass)) {
            return true;
        }
        return false;
    }
    
    protected boolean chekLogin(int id,String pass){
        return this.login(id, pass) ;
    }
}
