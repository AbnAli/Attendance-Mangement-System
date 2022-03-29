
package AdminGUI;

import static AdminGUI.AddNewStudent.window;
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
import attendencemanagmentsystem.Student;
import attendencemanagmentsystem.Teacher;
import attendencemanagmentsystem.User;

public class EditInfo {
    
    static Stage window = new Stage();
    
    public static void display(User u ,boolean type){
        TextField seName =new TextField();
        TextField se_lname =new TextField();
        TextField seId =new TextField();
        seId.disabledProperty();
        TextField seMail =new TextField();
 
        Label SeName =new Label("First Name: ");
        Label Se_lname =new Label("Last Name: ");
        Label Se_Phone =new Label("Id: ");
        Label Se_Mail =new Label("E-Mail: ");
        Button submit1=new Button("Submit");
        submit1.setOnAction(e->save(seMail,seName,se_lname,seId,type));
 
        Button Back4= new Button("Home");
        Back4.setOnAction(e->back());
 
        GridPane grid6 = new GridPane();
 
        grid6.add(SeName,0,0);
        grid6.add(Se_lname,0,1);
        grid6.add(Se_Phone,0,2);
        grid6.add(Se_Mail,0,3);
 
        grid6.add(seName,1,0);
        grid6.add(se_lname,1,1);
        grid6.add(seId,1,2);
        grid6.add(seMail,1,3);
 
        grid6.add(Back4,0,5);
        grid6.add(submit1,1,4);
 
        grid6.setVgap(20);
        grid6.setHgap(20);
        grid6.setAlignment(Pos.CENTER);
        grid6.setPadding(new Insets(50,50,50,50));
        Scene editSinfo = new Scene(grid6,600,300);
        showData(seMail,seName,se_lname,seId,u);
        window.show();
    }
    
    private static void save(TextField m,TextField f,TextField l,TextField Id,boolean t){
        Admin A = new Admin();
        boolean flag ;
        User u ;
        int id = Integer.valueOf(Id.getText());
        String eMail = m.getText();
        String fname = f.getText();
        String lname = l.getText();
        if(t)
            flag = A.updateStudentData(id, eMail, fname, lname);
        else
            flag = A.updateStudentData(id, eMail, fname, lname);
        
        if(flag)
            System.out.println("Done\n");
        else
            System.out.println("Fail\n");
    }
    
    private static void showData(TextField m,TextField f,TextField l,TextField id,User u){
        m.setText(u.geteMail());
        f.setText(u.getFName());
        l.setText(u.getLName());
        id.setText(u.getID()+"");
        id.disabledProperty();
    }
    private static void back(){
         window.close();
         AdminMain.display();
     }
}
