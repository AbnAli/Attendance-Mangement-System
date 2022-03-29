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
import attendencemanagmentsystem.Student;


public class DeleteStudent {
    static Stage window = new Stage();
    
    public static void display(){
        
        Label enterS = new Label("Enter Student ID :");
        TextField sID =new TextField();
        Button edit = new Button("Edit info");
        edit.setOnAction(e->edit(sID));
        Button delete = new Button("Delete");
        delete.setOnAction(e->delete(sID));
        Button Back = new Button("Back");
        Back.setOnAction(e->back());
        GridPane grid2 = new GridPane();
 
        grid2.add(enterS,1,0);
        grid2.add(sID,1,2);
        grid2.add(edit,1,5);
        grid2.add(delete,2,5);
        grid2.add(Back,0,6);
        grid2.setVgap(20);
        grid2.setHgap(20);
        grid2.setAlignment(Pos.CENTER);
        grid2.setPadding(new Insets(50,50,50,50));
        Scene mainPanel = new Scene(grid2, 600, 300);
        
        window.setScene(mainPanel);
        window.show();
    }
     
     private static void back(){
         window.close();
         AdminMain.display();
     }
     
     private static void edit(TextField Id){
        Admin A = new Admin();
        int id = Integer.valueOf(Id.getText());
        Student student = A.searchForStudent(id);
        if(student != null){
            System.out.println("Done"+student.getFName());
            EditInfo.display(student, false);
        }
        else
            System.out.println("Fail");
     }
     
     private static void delete(TextField Id){
         Admin A = new Admin();
         int id = Integer.valueOf(Id.getText());
         boolean s = A.deleteStudent(id);
         if(s)
             System.out.println("done");
         else
             System.out.println("faill");
     }
}
