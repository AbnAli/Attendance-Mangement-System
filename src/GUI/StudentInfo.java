package GUI;


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


public class StudentInfo extends Application {
    
    Stage window;
    Scene scene1 , scene2;
    
    @Override
    public void start(Stage primaryStage) {
        
        window = primaryStage;
        
        String sNameReviever = "ahmed";
        int sIDReciever = 0 ;
        String sPhoneReciever = "asgfo";
        String sMailReciever = "adgpkadgh";
        String sAddReciever = "adhgoahg";
        
          /*  componenets intialization */
        Label sName = new Label(sNameReviever);
        Label sID = new Label(""+sIDReciever);
        Label sPhone = new Label(sPhoneReciever);
        Label sMail = new Label(sMailReciever);
        Label sAdd = new Label(sAddReciever);
        
        TextField sNameEdit =new TextField();
        TextField sIDEdit =new TextField();
        TextField sPhoneEdit =new TextField();
        TextField sMailEdit =new TextField();
        TextField sAddEdit =new TextField();
        
        
        Label laName =new Label("Name: ");
        Label laID =new Label("ID: ");
        Label laPhone =new Label("Phone: ");
        Label laMail =new Label("E-Mail: ");
        Label laAdd =new Label("Address: ");
        Button editBtn=new Button("Edit ");
        Button saveBtn= new Button("Save ");
        Label laName2 =new Label("Name: ");
        Label laID2 =new Label("ID: ");
        Label laPhone2 =new Label("Phone: ");
        Label laMail2 =new Label("E-Mail: ");
        Label laAdd2 =new Label("Address: ");
        
        /* Set on action */
        editBtn.setOnAction(e->window.setScene(scene2));
        saveBtn.setOnAction(event ->window.setScene(scene1));
        
        GridPane grid = new GridPane();
        GridPane grid2 = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(20);
        grid2.setVgap(10);
        grid.setHgap(20);
        grid2.setHgap(10);
        grid.setAlignment(Pos.CENTER);
        grid2.setPadding(new Insets(10,10,10,10));

        /* Adding */
        grid.add(sName,1,0);
        grid.add(sID,1,1);
        grid.add(sPhone,1,2);
        grid.add(sMail,1,3);
        grid.add(sAdd,1,4);
        grid.add(laName2,0,0);
        grid.add(laID2,0,1);
        grid.add(laPhone2,0,2);
        grid.add(laMail2,0,3);
        grid.add(laAdd2,0,4);
        grid.add(editBtn,0,6);
      //   grid.add(saveBtn,1,6);
         
       
        grid2.add(sNameEdit,1,0);
        grid2.add(sIDEdit,1,1);
        grid2.add(sPhoneEdit,1,2);
        grid2.add(sMailEdit,1,3);
        grid2.add(sAddEdit,1,4);
        grid2.add(laName,0,0);
        grid2.add(laID,0,1);
        grid2.add(laPhone,0,2);
        grid2.add(laMail,0,3);
        grid2.add(laAdd,0,4);
        //grid2.add(editBtn,0,6);
        grid2.add(saveBtn,1,6);

         scene1 = new Scene(grid, 250, 250);
         scene2 = new Scene(grid2,250,250);

        window.setTitle("StudentInfo");
        window.setScene(scene1);
        window.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
