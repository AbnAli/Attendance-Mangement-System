
package TeacherGUI;




//import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JTextField;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;




public class Teacher extends Application {
    Stage window;
    Scene teacherPanel ,viewHandoverPanel,feesPanel,viewAttPanel,editProfPanel;
    TableView<product> feesTable;
    TableView<handoverTeacher> handOverTable;
    TableView<studentAtt> attTable;

    
    @Override
    public void start(Stage primaryStage) {
        /* components */
       
        
        window=primaryStage;
        //teacher main panel
        Button viewLecHandoverBtn = new Button("viewLec&Handover");
        viewLecHandoverBtn.setOnAction(e->window.setScene(viewHandoverPanel));
       
        Button viewStuFeesBtn = new Button("didn`t pay the fees");
        viewStuFeesBtn.setOnAction(e->window.setScene(feesPanel));
        
        Button viewAttbtn = new Button("View Stu Attendendcce");
        //viewAttbtn.setOnAction(e->window.setScene(viewAttPanel));
       
        Button editProfBtn = new Button("Edit Profile");
       //editProfBtn.setOnAction(e->window.setScene(editProfPanel));
       
       /*teacher panel start*/
       GridPane teacherGrid = new GridPane();
       teacherGrid.add(viewLecHandoverBtn,0,0);
       teacherGrid.add(viewStuFeesBtn,0,1);
       teacherGrid.add(viewAttbtn,0,2);
       teacherGrid.add(editProfBtn,0,3);
       teacherGrid.setVgap(20);
       teacherGrid.setHgap(20);
       teacherGrid.setAlignment(Pos.CENTER);
       teacherGrid.setPadding(new Insets(50,50,50,50));
       teacherPanel= new Scene(teacherGrid,1000, 500);
       /*end of teacher main*/
       
       //viewHandoverPanel start
       Label handLa = new Label("Enter Handover lecture ID :");
        TextField lecIdHandTxt = new TextField();
        Button handConfirmBtn = new Button("Confirm");
           
           
             TableColumn<handoverTeacher,Integer> handTeachName = new TableColumn<>("CourseId");
        handTeachName.setMinWidth(200);
        handTeachName.setCellValueFactory(new PropertyValueFactory<>("name"));// has to be the same as in the class Product
        
        TableColumn<handoverTeacher,Integer> handTeachId = new TableColumn<>("LecID");
        handTeachId.setMinWidth(200);
        handTeachId.setCellValueFactory(new PropertyValueFactory<>("id"));// has to be the same as in the class Product
        
     
        handOverTable = new TableView<>();
        handOverTable.setItems(getHandover());
        handOverTable.getColumns().addAll(handTeachName,handTeachId);
        
         VBox handBox = new VBox();
        handBox.getChildren().addAll(handOverTable);
        
        
          ChoiceBox<String> teachNames = new ChoiceBox<>();
           teachNames.setValue("-select-");
          teachNames.getItems().addAll("-select-","1005","1013","1015","1025","1027");
          Button handOverBtn = new Button("Handover lecture");
        handOverBtn.setOnAction(event ->getTeacherHandoverName(teachNames));
          
       
          
          GridPane viewHandoverGrid = new GridPane();
          viewHandoverGrid.add(handLa,1,11);
          viewHandoverGrid.add(lecIdHandTxt,1,12);
          viewHandoverGrid.add(handConfirmBtn,2,12);
             handConfirmBtn.setOnAction(event -> {
                viewHandoverGrid.add(teachNames,1,13);
                viewHandoverGrid.add(handOverBtn,2,13);
    });
           viewHandoverGrid.setAlignment(Pos.CENTER);
        viewHandoverGrid.setPadding(new Insets(10,10,10,10));
        viewHandoverGrid.setHgap(5);
        viewHandoverGrid.setVgap(5);
          
           viewHandoverPanel = new Scene(viewHandoverGrid,1000,500);
            viewHandoverGrid.add(handBox,1,2);
           
           
           
          
       
       //handoverpanel end
       
       
       

        // fees Panel start
        Label la_1 = new Label("Table of Students who didn`t pay fees  ");
        Label la_2 = new Label("Enter The Student ID :  ");
        TextField StuFeesId = new TextField();
        Button deleteStu = new Button("Delete");
        
         TableColumn<product,String> feeStuName = new TableColumn<>("Name");
        feeStuName.setMinWidth(200);
        feeStuName.setCellValueFactory(new PropertyValueFactory<>("name"));// has to be the same as in the class Product
        
        TableColumn<product,Integer> feeStuId = new TableColumn<>("ID");
        feeStuId.setMinWidth(200);
        feeStuId.setCellValueFactory(new PropertyValueFactory<>("id"));// has to be the same as in the class Product
        
     
        feesTable = new TableView<>();
        feesTable.setItems(getProduct());
        feesTable.getColumns().addAll(feeStuName,feeStuId);
        
        
        
        
        
        VBox feesBox = new VBox();
        feesBox.getChildren().addAll(feesTable);
        
        
        GridPane feesGrid = new GridPane();
        feesGrid.add(la_1,1,0);
        feesGrid.add(la_2,1,13);
        feesGrid.add(StuFeesId,1,14);
        feesGrid.add(deleteStu,1,15);
       
        feesGrid.setAlignment(Pos.CENTER);
        feesGrid.setPadding(new Insets(10,10,10,10));
        feesGrid.setHgap(5);
        feesGrid.setVgap(5);
         feesPanel = new Scene(feesGrid,1000,500);
          feesGrid.add(feesBox,1,2);
        
        
        
        deleteStu.setOnAction(event -> {
            System.err.println("delete working");
        });
        
        // fees Panel end
        
        
        
        
        
        // Student Att  start 
        
        Label stuAttLa = new Label("Student Attendence Table");
        
          TableColumn<studentAtt,String> studentAttName = new TableColumn<>("Name");
        studentAttName.setMinWidth(200);
        studentAttName.setCellValueFactory(new PropertyValueFactory<>("name"));// has to be the same as in the class Product
  
      TableColumn<studentAtt,Boolean> studentAttRatio = new TableColumn<>("Att. Ratio");
        studentAttRatio.setMinWidth(200);
        studentAttRatio.setCellValueFactory(new PropertyValueFactory<>("ratio"));// has to be the same as in the class Product
  
        
           TableColumn<studentAtt,Boolean> studentAttWeek1 = new TableColumn<>("Week 1");
        studentAttWeek1.setMinWidth(200);
        studentAttWeek1.setCellValueFactory(new PropertyValueFactory<>("week1"));// has to be the same as in the class Product
  
        
           TableColumn<studentAtt,Boolean> studentAttWeek2 = new TableColumn<>("Week 2");
        studentAttWeek2.setMinWidth(200);
        studentAttWeek2.setCellValueFactory(new PropertyValueFactory<>("week2"));// has to be the same as in the class Product
  
        
           TableColumn<studentAtt,Boolean> studentAttWeek3 = new TableColumn<>("Week3");
        studentAttWeek3.setMinWidth(200);
        studentAttWeek3.setCellValueFactory(new PropertyValueFactory<>("week3"));// has to be the same as in the class Product
  
        
           TableColumn<studentAtt,Boolean> studentAttWeek4 = new TableColumn<>("Week 4");
        studentAttWeek4.setMinWidth(200);
        studentAttWeek4.setCellValueFactory(new PropertyValueFactory<>("week4"));// has to be the same as in the class Product
  
        
        
        feesTable = new TableView<>();
        feesTable.setItems(getProduct());
        feesTable.getColumns().addAll(feeStuName,feeStuId);
        
        
        
             GridPane stuAttGrid = new GridPane();
             viewAttPanel = new Scene(stuAttGrid,1000,500);
        // Student Att end
 
        


        // editProf start
        
        
         GridPane editProfGrid = new GridPane();
          editProfPanel = new Scene(editProfGrid,1000,500);
        // editProf end
         
        window.setTitle("Teacher Window");
        window.setScene(teacherPanel);
        window.show();
    }

 
    public static void main(String[] args) {
        launch(args);
    }
   
  ///////////////////////////////////// fees table
     public ObservableList<product> getProduct(){
        ObservableList<product> products = FXCollections.observableArrayList(); 
       
            products.add(new product ("Gamal Ahmed",20180123));
            
            products.add(new product ("Abddelrhman Salah",20180145));
            products.add(new product ("Hussein Saaed",20180362));
            products.add(new product ("Ahmed Muhamed",20180125));
            products.add(new product ("Farouk Nasser",20180415));
            products.add(new product ("Ahmed Mohsin",20180171));
            products.add(new product ("Mahmoud Ahmed",20180345));
            products.add(new product ("Abdelrahman Shawky",20180754));
       
        return products;
    }

     
     
     //////////////////////////////////////// handover drop down choises
    private void getTeacherHandoverName(ChoiceBox<String> teachNames) {
        String choise = teachNames.getValue(); //To change body of generated methods, choose Tools | Templates.
        System.out.println(choise);
    }

    private ObservableList<handoverTeacher> getHandover() {
     ObservableList<handoverTeacher> handLec = FXCollections.observableArrayList(); 
       handLec.add(new handoverTeacher ("114",12)); 
       handLec.add(new handoverTeacher ("125",13)); 
       handLec.add(new handoverTeacher ("124",22)); 
       handLec.add(new handoverTeacher ("145",31)); 
       handLec.add(new handoverTeacher ("167",45)); 
         return handLec;
    }

    private void confirm() {
         System.out.println("confirm working"); // code here
          
    }
    
    
}

