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
import attendencemanagmentsystem.Teacher;

public class AddLectureToTeacher {
    static Stage window = new Stage();
    
    public static void display(){
        
         Label slID = new Label("Enter student ID:");
        TextField SlID = new TextField();
        Label slectureID = new Label("Enter Lecture ID:"); 
        TextField SlectureID = new TextField();
        Button addl = new Button("Add");
        addl.setOnAction(e->addLecture(SlID,SlectureID));
        Button dell_ls = new Button("Delete");
        dell_ls.setOnAction(e->back());

        Button Back6=new Button("Back");
        Back6.setOnAction(e->deleteLecture(SlID,SlectureID));
 
        GridPane grid8 = new GridPane();
        grid8.add(slID,0,0);
        grid8.add(SlID,1,0);
        grid8.add(slectureID,0,1);
        grid8.add(SlectureID,1,1);
        grid8.add(addl,0,2);
        grid8.add(dell_ls, 1, 2);
        grid8.add(Back6, 0, 3);
        grid8.setVgap(20);
        grid8.setHgap(20);
        grid8.setAlignment(Pos.CENTER);
        grid8.setPadding(new Insets(50,50,50,50));
        Scene mainPanel = new Scene(grid8, 750, 400);
        window.setScene(mainPanel);
        window.show();
    }
     
     private static void back(){
         window.close();
         AdminMain.display();
     }
     
     private static void addLecture(TextField stuId,TextField lecId){
         Teacher TA = new Teacher();
         int sId = Integer.valueOf(stuId.getText());
         int lId = Integer.valueOf(lecId.getText());
         boolean  falg = TA.addLecture(lId, lId);
         if(falg)
             System.out.println("Done");
         else
             System.out.println("Fail");
     }
     
     private static void deleteLecture(TextField stuId,TextField lecId){
         Teacher TA = new Teacher() ;
         int sId = Integer.valueOf(stuId.getText());
         int lId = Integer.valueOf(lecId.getText());
         boolean  falg = TA.removeLecture(lId, lId);
         if(falg)
             System.out.println("Done");
         else
             System.out.println("Fail");
     }
     
     public static void main(String[] args) {
        
    }
     
}
