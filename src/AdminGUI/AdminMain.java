
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


public class AdminMain {
    static Stage window = new Stage();
    public static void display(){
        
        
        Button Edit_deleteS = new Button("Edit/Delete Student");
        Edit_deleteS.setOnAction(e->deleteStudent());
 
        Button Edit_deleteT = new Button("Edit/Delete Teacher");
        Edit_deleteT.setOnAction(e->deletTeacher());
 
        Button addS = new Button("Add Student");
        addS.setOnAction(e->addStudent());
 
        Button addT = new Button("Add Teacher");
        addT.setOnAction(e->addTeacher());
 
        Button add_deleteL = new Button("Add/Delete L to Teacher");
        add_deleteL.setOnAction(e->addLectureTeacher());
 
        Button add_deleteL2 = new Button("Add/Delete L to Studet");
        add_deleteL2.setOnAction(e->addLectureStudent());
 
        Button show_report = new Button("Show Report");
        //show_report.setOnAction(e->window.setScene(showreport));
 
        GridPane grid = new GridPane();
        grid.add(addS,0,0);
        grid.add(addT,2,0);
        grid.add(Edit_deleteS,0,1);
        grid.add(Edit_deleteT,2,1);
        grid.add(add_deleteL2,0,2);
        grid.add(add_deleteL,2,2);
        grid.add(show_report,1,3);
        grid.setVgap(20);
        grid.setHgap(20);
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(50,50,50,50));
        Scene mainPanel = new Scene(grid, 750, 400);
        window.setScene(mainPanel);
        window.showAndWait();
    }
    
    private static void addStudent(){
        window.close();
        AddNewStudent.display();
    }
    
    private static void deleteStudent(){
        window.close();
        DeleteStudent.display();
    }
    
    private static void deletTeacher(){
        window.close();
        DeleteTeacher.display();
    }
    
    private static void addTeacher(){
        window.close();
        AddNewTeacher.display();
    }
    
    private static void addLectureTeacher(){
        window.close();
        AddLectureToTeacher.display();
    }
    
    private static void addLectureStudent(){
        window.close();
        AddLectureToStudent.display();
    }
    
    private static void report(){
        
    }
    
}
