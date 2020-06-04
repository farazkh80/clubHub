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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faraz Khoubsirat
 */
public class admin {

    public static String username;
    public static String password;

    Scanner input = new Scanner(System.in);

    public void setUsername() {
        System.out.println("Enter the Username");
        username = input.nextLine();

    }

    public void setPassword() {

        System.out.println("Enter the Password");
        password = input.nextLine();

    }

    public String getUserName() {

        return username;
    }

    public String getPassword() {

        return password;
    }

    public Boolean checkAdmin() {
        boolean loggedIn = false;
        int tryTimes = 0;
        do {

            tryTimes++;
            setUsername();
            setPassword();

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin", "root", "Mypassword1234");
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery("SELECT * FROM adminlist");
                rs.beforeFirst();
                while (rs.next()) {

                    if (getUserName().equals(rs.getString("username")) && getPassword().equals(rs.getString("password"))) {

                        loggedIn = true;
                        break;

                    } else {

                        loggedIn = false;

                    }
                }
                if (!loggedIn) {
                    System.out.println("incorrect username or password");
                }

            } catch (ClassNotFoundException | SQLException ex) {

                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);

            }
        } while (loggedIn == false && tryTimes <= 3);

        if (loggedIn == true) {
            System.out.println("Logged in");
            return true;
        } else {
            System.out.println("Too many wrong entries. Try again later.");
            return false;
        }

    }

    public void changePassword() {

        boolean currentPassMatched = true;
        input.nextLine();
        do {

            System.out.println("To Confirm Your Identity, Please enter your cuurent password again.");
            String userEntry = input.nextLine();
            if (userEntry.equals(getPassword())) {
                currentPassMatched = true;
                boolean newPassesMatched = true;
                do {
                    System.out.println("Idetity Verfied, please enter your new password:");
                    String userFirstEntry = input.nextLine();
                    System.out.println("Please enter your new password again:");
                    String userSecondEntry = input.nextLine();

                    if (userFirstEntry.equals(userSecondEntry)) {
                        newPassesMatched = true;
                        String newPassword = userFirstEntry;

                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin", "root", "Mypassword1234");
                            PreparedStatement stmt = con.prepareStatement("UPDATE adminlist SET password = ? WHERE username = ?");
                            stmt.setString(1, newPassword);

                            stmt.setString(2, getUserName());

                            stmt.executeUpdate();
                            System.out.println("Succesfully Changed.");
                            stmt.close();

                        } catch (ClassNotFoundException | SQLException ex) {

                            Logger.getLogger(club.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        newPassesMatched = false;
                        System.out.println("password didn't match");
                    }
                } while (newPassesMatched == false);
            } else {
                currentPassMatched = false;
                System.out.println("incorrect password, action failed");
            }
        } while (currentPassMatched == false);

    }

    public void addAdmin() {

        boolean matched = true;
        input.nextLine();
        System.out.println("Enter a username of the new admin:");
        String newAdminUserName = input.nextLine();
        do {
            System.out.println("Enter a password for " + newAdminUserName);
            String newAdminFirstPasswordEntry = input.nextLine();
            System.out.println("Enter the password again for " + newAdminUserName);
            String newAdminSecondPasswordEntry = input.nextLine();

            if (newAdminFirstPasswordEntry.equals(newAdminSecondPasswordEntry)) {
                matched = true;
                String newAdminPassword = newAdminFirstPasswordEntry;
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin", "root", "Mypassword1234");
                    PreparedStatement stmt = con.prepareStatement("INSERT INTO adminList (username, password) VALUES (?, ?)");
                    stmt.setString(1, newAdminUserName);
                    stmt.setString(2, newAdminPassword);
                    stmt.execute();
                    System.out.println("Succesfully Added.");
                    stmt.close();

                } catch (ClassNotFoundException | SQLException ex) {

                    Logger.getLogger(club.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                matched = false;
                System.out.println("Passwords are not matching.");
            }
        } while (matched == false);

    }

    public void deleteAdmin() {
        String user;

        boolean matched = false;
        input.nextLine();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin", "root", "Mypassword1234");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM adminlist");
            while (rs.next()) {

                user = rs.getString("username");
                System.out.println("Username: " + user);
                System.out.println("");
            

            }
        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(club.class.getName()).log(Level.SEVERE, null, ex);
        }

        do {
            System.out.println("Enter the username you want to delete");
            String deletedUsernameFirstEntry = input.nextLine();
            System.out.println("Enter the username you want to delete again");
            String deletedUsernameSecondEntry = input.nextLine();
            if (deletedUsernameFirstEntry.equals(deletedUsernameSecondEntry)) {
                matched = true;
                String deletedUsername = deletedUsernameFirstEntry;

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin", "root", "Mypassword1234");
                    PreparedStatement stmt = con.prepareStatement("DELETE FROM adminList WHERE username = ?");
                    stmt.setString(1, deletedUsername);
                    stmt.execute();
                    System.out.println("Succesfully deleted.");
                    stmt.close();

                } catch (ClassNotFoundException | SQLException ex) {

                    Logger.getLogger(club.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {

                System.out.println("Didn't match");
                matched = false;
            }

        } while (matched == false);

    }

    public void adminOperations() {
        int id;
        String name;
        int size;
        String manager;
        String location;
        String contin = "yes";
        club test = new club();
        do {
            System.out.println("What would you ilke to do?");
            System.out.println("1-Insert a new Club\n2-Get the list of current clubs\n3-Update a club\n4-Change Password\n5-Add a new admin\n6-Delete an admin");
            int userAction = input.nextInt();
            switch (userAction) {

                case 1:

                    input.nextLine();
                    System.out.println("Enter the Club Name: ");
                    name = input.nextLine();

                    System.out.println("Enter the Club Size");
                    size = input.nextInt();

                    input.nextLine();
                    System.out.println("Enter the Club Manager Name");
                    manager = input.nextLine();

                    System.out.println("Enter the club Location");
                    location = input.nextLine();

                    test.addClub(name, size, manager, location);

                    break;

                case 2:

                    test.getClubData();
                    break;

                case 3:
                    System.out.println("See the list of clubs first");
                    test.getClubData();
                    System.out.print("Enter the id of the club you would like to update: ");
                    id = input.nextInt();
                    System.out.println("What would you like to update: ");
                    System.out.println("1-Name\n2-Size\n3-Manager\n4-Location");
                    int userUpdateChoice = input.nextInt();
                    switch (userUpdateChoice) {

                        case 1:
                            input.nextLine();
                            System.out.println("Enter the new NAME: ");
                            name = input.nextLine();
                            test.changeName(id, name);
                            break;

                        case 2:
                            input.nextLine();
                            System.out.println("Enter the new SIZE: ");
                            size = input.nextInt();
                            test.changeSize(id, size);
                            break;
                        case 3:
                            input.nextLine();
                            System.out.println("Enter the new MANAGER: ");
                            manager = input.nextLine();
                            test.changeManager(id, manager);
                            break;
                        case 4:
                            input.nextLine();
                            System.out.println("Enter the new Location: ");
                            location = input.nextLine();
                            test.changeLocation(id, location);
                            break;

                    }
                    break;

                case 4:

                    changePassword();

                    break;

                case 5:

                    addAdmin();
                    break;

                case 6:

                    deleteAdmin();

            }

            System.out.println("Would you like to continue");

            contin = input.next();

        } while (contin.equalsIgnoreCase("yes"));
    }

}
