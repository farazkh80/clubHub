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
public class student {

    private static String clubName;
    private static String studentFirstName;
    private static String studentLastName;
    private static int studentGrade;
    private static int studentNumber;
    dataBaseCon db = new dataBaseCon();

    public void addMember(String cName, String fname, String lname, int grade, int studentNum) {

        clubName = cName;
        studentFirstName = fname;
        studentLastName = lname;
        studentGrade = grade;
        studentNumber = studentNum;

        db.addMember(clubName, studentFirstName, studentLastName, studentGrade, studentNumber);

    }
}
