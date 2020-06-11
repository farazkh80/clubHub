/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clubhub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faraz Khoubsirat
 */
public class dataBaseCon {

    public static void main(String args[]) {

    }

    void insertData(String clubName, int clubSize, String clubManager, String clubLocation) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clubs", "root", "Mypassword1234");
            PreparedStatement stmt = con.prepareStatement("INSERT INTO clublist (name, size, manager, location) VALUES (?, ?, ?, ?)");
            stmt.setString(1, clubName);
            stmt.setInt(2, clubSize);
            stmt.setString(3, clubManager);
            stmt.setString(4, clubLocation);
            stmt.execute();
            System.out.println("Succesfully entered.");
            stmt.close();

        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(club.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void getData() {
        int clubId;
        String clubName;
        int clubSize;
        String clubManager;
        String clubLocation;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clubs", "root", "Mypassword1234");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM clublist");
            while (rs.next()) {

                clubId = rs.getInt("id");
                clubName = rs.getString("name");
                clubSize = rs.getInt("size");
                clubManager = rs.getString("manager");
                clubLocation = rs.getString("location");
                System.out.println("ID: " + clubId);
                System.out.println("Name: " + clubName);
                System.out.println("Size: " + clubSize);
                System.out.println("Manager: " + clubManager);
                System.out.println("Location: " + clubLocation);
                System.out.println("");
                System.out.println("");

            }
        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(club.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void updateDataName(int clubCurrentid, String clubNewName) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clubs", "root", "Mypassword1234");
            PreparedStatement stmt = con.prepareStatement("UPDATE clublist SET name = ? WHERE id = ?");

            stmt.setString(1, clubNewName);

            stmt.setInt(2, clubCurrentid);

            stmt.executeUpdate();
            System.out.println("Succesfully Updated.");
            stmt.close();

        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(club.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void updateDataSize(int clubCurrentid, int clubNewSize) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clubs", "root", "Mypassword1234");
            PreparedStatement stmt = con.prepareStatement("UPDATE clublist SET size = ? WHERE id = ?");

            stmt.setInt(1, clubNewSize);

            stmt.setInt(2, clubCurrentid);

            stmt.executeUpdate();
            System.out.println("Succesfully Updated.");
            stmt.close();

        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(club.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void updateDataManager(int clubCurrentid, String clubNewManager) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clubs", "root", "Mypassword1234");
            PreparedStatement stmt = con.prepareStatement("UPDATE clublist SET manager = ? WHERE id = ?");

            stmt.setString(1, clubNewManager);

            stmt.setInt(2, clubCurrentid);

            stmt.executeUpdate();
            System.out.println("Succesfully Updated.");
            stmt.close();

        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(club.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void updateDataLocation(int clubCurrentid, String clubNewLocation) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clubs", "root", "Mypassword1234");
            PreparedStatement stmt = con.prepareStatement("UPDATE clublist SET location  = ? WHERE id = ?");

            stmt.setString(1, clubNewLocation);

            stmt.setInt(2, clubCurrentid);

            stmt.executeUpdate();
            System.out.println("Succesfully Updated.");
            stmt.close();

        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(club.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void createTable(String tableName) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clubs", "root", "Mypassword1234");
            PreparedStatement stmt = con.prepareStatement("CREATE TABLE `" + tableName + "` (id int(100) PRIMARY KEY AUTO_INCREMENT NOT NULL,  firstname varchar(100) NOT NULL, lastname varchar(100) not null, grade int not null, studentnumber int not null);");

            stmt.executeUpdate();
            System.out.println("Succesfully Created the Table.");
            stmt.close();

        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(club.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void createTableForPosts(String tableName) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clubposts", "root", "Mypassword1234");
            PreparedStatement stmt = con.prepareStatement("CREATE TABLE `" + tableName + "` (id int(100) PRIMARY KEY AUTO_INCREMENT NOT NULL, post longtext not null, postdate DATE not null);");

            stmt.executeUpdate();
            System.out.println("Succesfully Created the Table.");
            stmt.close();

        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(club.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void deleteClub(int id) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clubs", "root", "Mypassword1234");
            PreparedStatement stmt = con.prepareStatement("DELETE FROM clublist WHERE id = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Succesfully Deleted the Club.");
            stmt.close();

        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(club.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void deleteTable(String tableName) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clubs", "root", "Mypassword1234");
            PreparedStatement stmt = con.prepareStatement("DROP TABLE `" + tableName + "`;");

            stmt.executeUpdate();
            System.out.println("Succesfully Deleted the Table.");
            stmt.close();

        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(club.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void addMember(String clubName, String fname, String lname, int grade, int studentNum) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clubs", "root", "Mypassword1234");
            PreparedStatement stmt = con.prepareStatement("INSERT INTO `" + clubName + "` (firstname, lastname, grade, studentnumber) VALUES (?, ?, ?, ?)");
            stmt.setString(1, fname);
            stmt.setString(2, lname);
            stmt.setInt(3, grade);
            stmt.setInt(4, studentNum);
            stmt.execute();
            System.out.println("Succesfully added.");
            stmt.close();

        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void memberIncreased(int clubId) {

        int currentSize = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clubs", "root", "Mypassword1234");
            String query = "SELECT * FROM clublist WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, clubId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                currentSize = rs.getInt("size");
            }

        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(club.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clubs", "root", "Mypassword1234");
            PreparedStatement stmt = con.prepareStatement("UPDATE clublist SET size = ? WHERE  id = ?");
            stmt.setInt(1, currentSize + 1);
            stmt.setInt(2, clubId);

            stmt.execute();
            System.out.println("Succesfully added.");
            stmt.close();

        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(club.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void getMemberList(String name) {
        int studentId;
        String studentFirstName;
        String studentLastName;
        int studentGrade;
        int studentStudentNumber;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clubs", "root", "Mypassword1234");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `" + name + "`");
            while (rs.next()) {

                studentId = rs.getInt("id");
                studentFirstName = rs.getString("firstname");
                studentLastName = rs.getString("lastname");
                studentGrade = rs.getInt("grade");
                studentStudentNumber = rs.getInt("studentnumber");

                System.out.println("Student id:\t " + studentId);
                System.out.println("Student First Name:\t" + studentFirstName);
                System.out.println("Student Last Name:\t" + studentLastName);
                System.out.println("Student Grade:\t" + studentGrade);
                System.out.println("Student Number:\t" + studentStudentNumber);
                System.out.println("");
                System.out.println("");

            }

        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(club.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void addNewPost(String clubName, String clubPost, String postDate) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clubposts", "root", "Mypassword1234");
            PreparedStatement stmt = con.prepareStatement("INSERT INTO `" + clubName + "` (post, postdate) VALUES (?, ?)");
            stmt.setString(1, clubPost);
            stmt.setString(2, postDate);
            stmt.execute();
            System.out.println("Succesfully added the post.");
            stmt.close();

        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(club.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void getPostsFromDataBase(String clubName) {

        String post;
        String date;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clubposts", "root", "Mypassword1234");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `" + clubName + "` ORDER BY postdate DESC");
            while (rs.next()) {

                
                post = rs.getString("post");
                date = rs.getString("postdate");
                System.out.print(date+"\t\t");
                System.out.println(post);
                System.out.println("");
                System.out.println("");

            }
        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(club.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
