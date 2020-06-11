/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clubhub;

import java.util.Scanner;

/**
 *
 * @author Faraz Khoubsirat
 */
public class adminEngine {

    admin Admin = new admin();
    Scanner input = new Scanner(System.in);
    club Club = new club();

    public void operationsList() {

        if (Admin.checkAdmin()) {

            int id;
            String name;
            int size;
            String manager;
            String location;
            String contin = "yes";
            do {
                System.out.println("What operation would you ilke to do?");
                System.out.println("1-Club Related\n2-Admin Related");
                int userOperationChoice = input.nextInt();
                if (userOperationChoice == 1) {
                    System.out.println("Choose an option:");
                    System.out.println("1-Insert a new Club\n2-Get the list of current clubs\n3-Update a club\n4-Delete a club\n5-Get the member list for a club\n6-See the posts for a specific clubs\n7-Add a current post");
                    int userClubAction = input.nextInt();

                    switch (userClubAction) {

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

                            Club.addClub(name, size, manager, location);
                            Club.createClubTable(name);
                            Club.createClubTableForPosts(name);

                            break;

                        case 2:

                            Club.getClubData();
                            break;

                        case 3:
                            System.out.println("See the list of clubs first");
                            Club.getClubData();
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
                                    Club.changeName(id, name);
                                    break;

                                case 2:
                                    input.nextLine();
                                    System.out.println("Enter the new SIZE: ");
                                    size = input.nextInt();
                                    Club.changeSize(id, size);
                                    break;
                                case 3:
                                    input.nextLine();
                                    System.out.println("Enter the new MANAGER: ");
                                    manager = input.nextLine();
                                    Club.changeManager(id, manager);
                                    break;
                                case 4:
                                    input.nextLine();
                                    System.out.println("Enter the new Location: ");
                                    location = input.nextLine();
                                    Club.changeLocation(id, location);
                                    break;

                            }
                            break;

                        case 4:
                            Club.getClubData();
                            System.out.println("What is the id of the club you would like to delete?");
                            int userIdEntry = input.nextInt();
                            input.nextLine();
                            System.out.println("What is the name of the club you would like to delete?");
                            String userNameEntry = input.nextLine();
                            System.out.println("Are you sure of deleting " + userNameEntry + " with the id of " + userIdEntry + " ?");
                            String userAnswer = input.next();
                            if (userAnswer.equalsIgnoreCase("yes")) {

                                if (Admin.checkPassword()) {

                                    Club.deleteClub(userIdEntry);

                                    Club.deleteClubTable(userNameEntry);
                                } else {

                                    System.out.println("failed");

                                }
                            }
                            break;
                            
                        case 5: 
                           Club.getClubData();
                           input.nextLine();
                            System.out.println("Enter the name of the club you would like to get the list of.");
                            String selectedClubName = input.nextLine();
                            Club.memberList(selectedClubName);
                            break;
                            
                        case 6:
                            Club.getClubData();
                            input.nextLine();
                            System.out.println("What club would you like to see the post of?(enter the name)");
                            String selectedClubNameForPostDisplay = input.nextLine();
                            Club.getPosts(selectedClubNameForPostDisplay);
                            break;
                            
                        case 7:
                            Club.getClubData();
                            input.nextLine();
                            System.out.println("What club would you like to add the post to?(enter the name)");
                            String selectedClubNameForPostEntry = input.nextLine();
                            System.out.println("Please Enter the post:");
                            String post = input.nextLine();
                            System.out.println("Please enter today's date (YYYY-MM-DD):");
                            String date = input.nextLine();
                            
                            Club.addPost(selectedClubNameForPostEntry, post, date);
                            break;
                            
                    }
                } else if (userOperationChoice == 2) {
                    System.out.println("Choose an option:");
                    System.out.println("1-Change Password\n2-Add a new admin\n3-Delete an admin");
                    int userAdminAction = input.nextInt();
                    input.nextLine();
                    switch (userAdminAction) {

                        case 1:
                            
                            Admin.changePassword();

                            break;

                        case 2:

                            Admin.addAdmin();
                            break;

                        case 3:

                            Admin.deleteAdmin();
                            break;

                    }
                }

                System.out.println("Would you like to continue");

                contin = input.next();

            } while (contin.equalsIgnoreCase("yes"));

        }

    }
}
