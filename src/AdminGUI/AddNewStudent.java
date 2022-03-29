
package AdminGUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JTextField;
import attendencemanagmentsystem.Admin;



public class AddNewStudent {
    
    static Stage window = new Stage();
    
    public static void display(){
        
        
        Label stname = new Label("Enter Student First Name:");
        Label stl_name =new Label("Enter Last Name: ");
        Label stMail =new Label("Enter E-Mail: ");
        Label stphone =new Label("Enter phone number: ");
 
        TextField sname =new TextField();
        TextField sl_name =new TextField();
        TextField smail =new TextField();
        TextField sphone =new TextField();
        Button addStudent = new Button("Add");
        addStudent.setOnAction(e->addStudent(smail,sname,sl_name));
        Button Back2 = new Button("Back");
        Back2.setOnAction(e->back());
        GridPane grid4 = new GridPane();
 
        grid4.add(stname,0,0);
        grid4.add(sname,0,1);
        grid4.add(stl_name,0,2);
        grid4.add(sl_name,0,3);
        grid4.add(stMail,0,4);
        grid4.add(smail,0,5);
        grid4.add(stphone,0,6);
        grid4.add(sphone,0,7);
        grid4.add(addStudent,0,8);
        grid4.add(Back2,1,9);
        grid4.setVgap(15);
        grid4.setHgap(20);
        grid4.setAlignment(Pos.CENTER);
        grid4.setPadding(new Insets(50,50,50,50));
        Scene mainPanel = new Scene(grid4, 750, 400);
        window.setScene(mainPanel);
        window.show();
    }
     
     private static void back(){
         window.close();
         AdminMain.display();
     }
     
     private static void addStudent(TextField e,TextField f,TextField l){
         Admin A = new Admin();
         String eMail = e.getText();
         String fName = f.getText();
         String lName = l.getText();
         boolean s = A.addStudent(eMail, fName, lName);
         if(s)
             System.out.println("done");
         else
             System.out.println("faill");
     }
}
