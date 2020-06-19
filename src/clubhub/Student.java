/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clubhub;

/**
 *
 * @author Faraz Khoubsirat
 */
public class Student {
    
    
    //declaring varibales for Student class
    private static String clubName;
    private static String studentFirstName;
    private static String studentLastName;
    private static int studentGrade;
    private static int studentNumber;
    DataBaseCon db = new DataBaseCon();
    
    //method to add a memeber
    public void addMember(String cName, String fname, String lname, int grade, int studentNum) {

        clubName = cName;
        studentFirstName = fname;
        studentLastName = lname;
        studentGrade = grade;
        studentNumber = studentNum;
        
        //calls db obj to insert a new member in club's member table
        db.addMember(clubName, studentFirstName, studentLastName, studentGrade, studentNumber);

    }
    //method to delete a memeber
    public void deleteMember(String cName, int studentNum){
        clubName = cName;
        studentNumber = studentNum;
        
        //calls db obj to delete the member in club's member table
        db.deleteMember(clubName, studentNumber);
    }
}
