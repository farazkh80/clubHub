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
    public static boolean loggedIn = false;
    Scanner input = new Scanner(System.in);

    public void setUsernameAndPassword() {
        System.out.println("Enter the Username");
        username = input.nextLine();
        System.out.println("Enter the Password");
        password = input.nextLine();

        System.out.println(username);
        System.out.println(password);

    }

    public String getUserName() {

        return username;
    }

    public String getPassword() {

        return password;
    }

    public Boolean checkAdmin() {

        setUsernameAndPassword();

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
            if (loggedIn == true) {
                System.out.println("Logged in");
                return true;
            } else {
                System.out.println("incorrect username or password");
                return false;
            }

        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }

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
            System.out.println("1-Insert a new Club\n2-Get the list of current clubs\n3-Update a club");
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

            }

            System.out.println("Would you like to continue");

            contin = input.next();

        } while (contin.equalsIgnoreCase("yes"));
    }

}
