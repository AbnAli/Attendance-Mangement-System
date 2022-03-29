/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendencemanagmentsystem;

import java.io.File;

/**
 *
 * @author abdelrhman
 */
public class Attendencemanagmentsystem {

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
        System.out.println(""+Student.Students.get(0).getID());
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
