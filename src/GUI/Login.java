package GUI ;

import AdminGUI.AdminMain;
import attendencemanagmentsystem.Admin;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import AdminGUI.AdminMain;
import static attendencemanagmentsystem.Attendencemanagmentsystem.checkDirectoryContents;
import attendencemanagmentsystem.Student;
import attendencemanagmentsystem.Teacher;
import java.io.File;

/**
 *
 * @author abdon
 */
public class Login extends Application {
    
    Stage window = null ;
    
    @Override
    public void start(Stage primaryStage) {
        
        window = primaryStage ;
        
        
        /*  componenets intialization */
        Label uNameLa = new Label("UserName:");
        uNameLa.setId("uName");
          TextField uNameTxt= new TextField();
           Label uPasswordLa = new Label("Password:");
          uNameLa.setId("password");
          PasswordField uPasswordTxt= new PasswordField();
           Label uDropDownLa = new Label("What kinda user are you ?");
           
          Button loginBtn = new Button("login");
          ChoiceBox<String> userDropDown = new ChoiceBox<>();
          userDropDown.setValue("-select-");
          userDropDown.getItems().addAll("-select-","Student","Teacher","Admin","Accountant");
        
        
        /* Set on action */
        loginBtn.setOnAction(event ->getChoice(userDropDown,uNameTxt,uPasswordTxt));
        
        
        
         GridPane grid = new GridPane();
        Scene scene = new Scene(grid, 1000,500);
//        scene.getStylesheets().add(Login.class.getResource("loginPageCSS.css").toExternalForm());
        
        /* Adding */
        grid.add(uNameLa,0,0);
        grid.add(uNameTxt, 1, 0);
        grid.add(uPasswordLa, 0, 2);        
        grid.add(uPasswordTxt, 1, 2);
        grid.add(loginBtn,2,5);
        grid.add(uDropDownLa, 1, 4);
        grid.add(userDropDown,1,5);
        
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(10,10,10,10));
        
        
        primaryStage.setTitle("Welcome To Attendance Mangemanet System Application !");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        System.out.println("Project Path: " + projectPath);
        File currentDir = new File(projectPath); 				
	checkDirectoryContents(currentDir);
        
        Student s = new Student();
        s.loadFromFile();
        System.out.println(""+Student.Students.get(Student.Students.size()-1).getFName());
        
        launch(args);
    }
    
    
    
    private void getChoice(ChoiceBox<String> userDropDown,TextField t,PasswordField p){ 
         // code that will be done when clicking Login btn
      String choise = userDropDown.getValue();
      String pass = p.getText();
      int id = Integer.valueOf(t.getText());
      switch (choise){
          case "Admin" :
              adminLogin(id,pass);
              break;
      }
    };
    
    
    private void adminLogin(int id ,String pass){
        Admin admin = new Admin();
        boolean log = admin.login(id, pass);
        if(log){
            window.close();
            AdminMain.display();
        }
    }
    
    public static void checkDirectoryContents(File dir){
        File[] files = dir.listFiles();
        boolean studentFile = true;
        boolean TAFile = true;
        boolean EmpFile = true;
        boolean courseFile = true;

        for (File file : files) {

            if (file.getName().contains("Students.bin")) {
                studentFile = false;
            } else if (file.getName().contains("Teacher.bin")) {
                TAFile = false;
            } else if (file.getName().contains("Employee.bin")) {
                EmpFile = false;
            } else if (file.getName().contains("Courses.bin")) {
                courseFile = false;
            }
        }
        if (studentFile) {
            Student x = new Student();
            x.commitToFile();
        } 
        
       
        
        if (TAFile) {
            Teacher x = new Teacher();
            x.commitToFile();
        } 
        
        
    }
}
