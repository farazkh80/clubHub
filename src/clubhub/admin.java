package clubhub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faraz Khoubsirat
 */
public class admin {

    //declaring the variables username and password for admin
    public static String username;
    public static String password;
    dataBaseCon db = new dataBaseCon();

    Scanner input = new Scanner(System.in);

    //setUsername methods promts the admin to enter their username
    public void setUsername() {
        System.out.println("Enter the Username");
        username = input.nextLine();

    }

    //setPassword methods promts the admin to enter their password
    public void setPassword() {

        System.out.println("Enter the Password");
        password = input.nextLine();

    }

    //getUsername method returns the username
    public String getUsername() {

        return username;
    }

    //getPassword method returns the password
    public String getPassword() {

        return password;
    }

    Connection adminCon() throws ClassNotFoundException {

        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin", "root", "Mypassword1234");
        } catch (SQLException ex) {
            Logger.getLogger(dataBaseCon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    //checkAdmin method checks if the admin username and password entries are in the database
    public Boolean checkAdmin() {
        boolean loggedIn = false;
        boolean overTried = false;
        int tryTimes = 0;
        do {

            tryTimes++;

            //promts the admin for username and password
            setUsername();
            setPassword();

            if (db.checkAdmin(getUsername(), getPassword())) {
                loggedIn = true;
            } else {
                loggedIn = false;
            }

        } while (loggedIn == false && tryTimes < 3); //if the unsuccesful entries are more than 3, it ends the program

        //if logged in return true
        if (loggedIn == true) {
            System.out.println("\n\n");
            System.out.println("Logged in");
            return true;
        } else {
            System.out.println("\n\n");
            System.out.println("Too many wrong entries. Try again later.");
            return false;
        }

    }

    //the method to check the password of the admin for security reasons
    public boolean checkPassword() {
        boolean currentPassMatched = true;

        do {

            System.out.println("To Confirm Your Identity, Please enter your cuurent password.");
            String userEntry = input.nextLine();
            //returns if the entry matches with their password
            if (userEntry.equals(getPassword())) {
                currentPassMatched = true;
            } else {
                currentPassMatched = false;
                System.out.println("password didn't match");
            }
        } while (currentPassMatched == false); //it doesn't stop untill they enter the pass right.

        return currentPassMatched;

    }

    //the method to change the admin's password
    public void changePassword() {
        //it checks the users identity using checkPassword() method.
        if (checkPassword()) {

            boolean newPassesMatched = true;
            do {
                //if verified, it promts for a new password
                System.out.println("Idetity Verfied, please enter your new password:");
                String userFirstEntry = input.nextLine();
                //it double checks the passwords
                System.out.println("Please enter your new password again:");
                String userSecondEntry = input.nextLine();

                //if matching it enters the new password in the database
                if (userFirstEntry.equals(userSecondEntry)) {
                    newPassesMatched = true;
                    String newPassword = userFirstEntry;

                    db.changePassword(getUsername(), newPassword);

                } else {
                    //shows the message below if the new password entries don't match
                    newPassesMatched = false;
                    System.out.println("password didn't match");
                }
            } while (newPassesMatched == false); //doesn't stop the do-while loop untill the user enters matching passwords.

        }
    }

    //Adds an admin to the adminlist
    public void addAdmin() {

        boolean matched = true;

        //asks for a username for the admin
        System.out.println("Enter a username of the new admin:");
        String newAdminUserName = input.nextLine();
        do {
            //promts the admin to choose a password for the new admin
            System.out.println("Enter a password for " + newAdminUserName);
            String newAdminFirstPasswordEntry = input.nextLine();
            //promts the admin to enter it again
            System.out.println("Enter the password again for " + newAdminUserName);
            String newAdminSecondPasswordEntry = input.nextLine();

            //if two entries matched, it configures the database connection to insert a new admin
            if (newAdminFirstPasswordEntry.equals(newAdminSecondPasswordEntry)) {
                matched = true;
                String newAdminPassword = newAdminFirstPasswordEntry;
                db.addAdmin(newAdminUserName, newAdminPassword);
            } else {
                //shows the message if the two entries don't match
                matched = false;
                System.out.println("Passwords are not matching.");
            }
        } while (matched == false); //doesn't stop until the two passes match

    }

    //method to show all the current admins
    public void getAdminList() {
        System.out.println("Here is the list of current admins:\n");
        db.getAdminList();

    }

    //method to delete an Admin from the database
    public void deleteAdmin() {

        boolean matched = false;

        do {
            //asks the user for the username they would like to delete
            System.out.println("Enter the username you want to delete");
            String deletedUsernameFirstEntry = input.nextLine();
            //asks the user for the username they would like to delete again
            System.out.println("Enter the username you want to delete again");
            String deletedUsernameSecondEntry = input.nextLine();
            //if matching it runs the configuration to database
            if (deletedUsernameFirstEntry.equals(deletedUsernameSecondEntry)) {
                matched = true;
                String deletedUsername = deletedUsernameFirstEntry;

                db.deleteAdmin(deletedUsername);
            } else {

                //shows the message if the two admin entries don't match
                System.out.println("Didn't match");
                matched = false;
            }

        } while (matched == false); //doesn't stop untill they match.

    }

}
