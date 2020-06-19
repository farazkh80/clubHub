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
public class AdminEngine {

    //decalring the objects
    Admin admin = new Admin();
    Scanner input = new Scanner(System.in);
    Club club = new Club();
    Student newStudent = new Student();

    //method to handle Admin opreations
    public void operations() {

        //if Admin login is successful runs the code
        if (admin.checkAdmin()) {

            //decalaring the variables
            int id;
            String name;
            int size;
            String manager;
            String location;
            String contin = "yes";
            do {
                System.out.println("\n\n\n\n");
                //promting user to choose if they want to adjust clubs or admins
                System.out.println("What operation would you like to do?");
                System.out.println("1-Club Related\n---------------------\n2-Admin Related\n---------------------\n3-Quit");
                int userOperationChoice = input.nextInt();
                //if clubs runs the code 
                if (userOperationChoice == 1) {
                    System.out.println("\n\n\n\n");
                    System.out.println("What type of data you would like to work on?");
                    System.out.println("1-Club Information Related\n---------------------\n2-Club Members Related\n---------------------\n"
                            + "3-Club Posts Related\n---------------------\n4-Quit");
                    int userClubRelatedOperationChoice = input.nextInt();

                    if (userClubRelatedOperationChoice == 1) {
                        System.out.println("\n\n\n\n");
                        //prompts the user to choose between 4 options
                        System.out.println("Choose an option:");
                        System.out.println("1-Insert a new Club\n---------------------\n2-Get the list of current clubs\n---------------------\n"
                                + "3-Update a club\n---------------------\n4-Delete a club\n---------------------\n5-Quit");
                        int userClubInformationAction = input.nextInt();

                        switch (userClubInformationAction) {

                            //if Admin chooses to insert a Club
                            case 1:

                                //gets the inforamtion for the new Club
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

                                //calls the Club object to add a new Club, create a member table and a post table for the Club name
                                club.addClub(name, size, manager, location);
                                club.createClubTable(name);
                                club.createClubTableForPosts(name);

                                break;

                            //if Admin chooses to get the Club list
                            case 2:

                                //calls the Club object to get the current Club list
                                club.getClubData();
                                break;

                            //if Admin chooses to update a Club information
                            case 3:
                                //shows the Club list first
                                System.out.println("See the list of clubs first");
                                club.getClubData();
                                //promts the Admin for the id of the desired Club
                                System.out.print("Enter the id of the club you would like to update: ");
                                id = input.nextInt();

                                //asks what information they would like to update
                                System.out.println("What would you like to update: ");
                                System.out.println("1-Name\n2-Size\n3-Manager\n4-Location");
                                int userUpdateChoice = input.nextInt();
                                switch (userUpdateChoice) {

                                    //if it is to change the name of the Club
                                    case 1:
                                        //promts the user for the new name
                                        input.nextLine();
                                        System.out.println("Enter the new NAME: ");
                                        name = input.nextLine();
                                        //calls the Club obj to change the name
                                        club.changeName(id, name);
                                        break;

                                    //if it is to change the size of the Club
                                    case 2:
                                        //promts the user for the new size
                                        input.nextLine();
                                        System.out.println("Enter the new SIZE: ");
                                        size = input.nextInt();
                                        //calls the Club obj to change the size
                                        club.changeSize(id, size);
                                        break;

                                    //if it is to change the manager of the Club
                                    case 3:
                                        //promts the user for the new manager
                                        input.nextLine();
                                        System.out.println("Enter the new MANAGER: ");
                                        manager = input.nextLine();
                                        //calls the Club obj to change the manager
                                        club.changeManager(id, manager);
                                        break;

                                    //if it is to change the location of the Club
                                    case 4:
                                        //promts the user for the new location
                                        input.nextLine();
                                        System.out.println("Enter the new Location: ");
                                        location = input.nextLine();
                                        //calls the Club obj to change the location
                                        club.changeLocation(id, location);
                                        break;

                                }
                                break;

                            //if Admin chooses to delete a Club
                            case 4:
                                //shows the current Club list first
                                club.getClubData();

                                //prompts the Admin for the id of the desired Club
                                System.out.println("What is the id of the club you would like to delete?");
                                int userIdEntry = input.nextInt();
                                //prompts the Admin for the id of the desired Club again
                                input.nextLine();
                                System.out.println("What is the name of the club you would like to delete?");
                                String userNameEntry = input.nextLine();
                                //asks if they of sure of deleting
                                System.out.println("Are you sure of deleting " + userNameEntry + " with the id of " + userIdEntry + " ?");
                                String userAnswer = input.next();
                                //if yes runs the code
                                if (userAnswer.equalsIgnoreCase("yes")) {

                                    if (admin.checkPassword()) {

                                        //calls the Club object to delete the Club from Club list using its id
                                        club.deleteClub(userIdEntry);

                                        //calls the Club object to delete the member and posts tables for the Club using its name
                                        club.deleteClubTable(userNameEntry);
                                    } else {
                                        //if no shows failed message
                                        System.out.println("failed to delete");

                                    }
                                }
                                break;

                            case 5:
                                System.out.println("\n\nSuccessfully quited");
                                System.exit(0);
                                break;
                        }
                    } //if the Admin chooses the member option
                    else if (userClubRelatedOperationChoice == 2) {
                        System.out.println("\n\n\n\n");
                        //prompts the user to choose between 1 options
                        System.out.println("Choose an option:");
                        System.out.println("1-Get the member list for a club\n---------------------\n2-Add a member to a Club\n---------------------\n"
                                + "3-Delete a member from a club\n---------------------\n4-Quit");
                        int userMembersAction = input.nextInt();

                        switch (userMembersAction) {

                            //if the Admin chooses to see the current list of members for a specific Club
                            case 1:
                                //shows the current list of clubs
                                club.getClubData();
                                //prmots the Admin to enter the name od desired Club
                                input.nextLine();
                                System.out.println("Enter the name of the club you would like to get the list of.");
                                String selectedClubName = input.nextLine();

                                //calls the Club object the get the list of members
                                club.memberList(selectedClubName);
                                break;
                            //if the Admin chooses to add a member for a specific Club
                            case 2:

                                club.getClubData();

                                //the Club id is asked to increase the size of the Club as the member gets added
                                System.out.println("\n\nEnter the id of the club you would like to add the student to:");
                                int clubJoinMemberId = input.nextInt();

                                //the Club name is asked to add the Student as a new member to the Club.
                                input.nextLine();
                                System.out.println("Enter the name of the club you would like to add the student to:");
                                String clubJoinMemberName = input.nextLine();

                                //promting the user for the information about them.
                                System.out.println("What is his/her First Name:");
                                String fname = input.nextLine();
                                System.out.println("What is his/her Last Name:");
                                String lname = input.nextLine();
                                System.out.println("What is his/her Grade:");
                                int grade = input.nextInt();
                                System.out.println("What is his/her student Number:");
                                int studentNum = input.nextInt();

                                //adds the Student to the Club
                                newStudent.addMember(clubJoinMemberName, fname, lname, grade, studentNum);

                                //increase the Club size as the member gets added.
                                club.memberAdded(clubJoinMemberId);

                                break;
                            
                             //if the Admin chooses to add a member for a specific Club
                            case 3:

                                club.getClubData();

                                //the Club id is asked to increase the size of the Club as the member gets added
                                System.out.println("\n\nEnter the id of the club you would like to add the student to:");
                                int clubDeleteMemberId = input.nextInt();

                                //the Club name is asked to add the Student as a new member to the Club.
                                input.nextLine();
                                System.out.println("Enter the name of the club you would like to delete the student from:");
                                String clubDeleteMemberName = input.nextLine();

                                //calls the Club object the get the list of members
                                club.memberList(clubDeleteMemberName);

                                System.out.println("What is his/her student Number:");
                                int DeletestudentNum = input.nextInt();

                                newStudent.deleteMember(clubDeleteMemberName, DeletestudentNum);

                                club.memberRemoved(clubDeleteMemberId);
                                break;
                            //if quits
                            case 4:
                                System.out.println("\n\nSuccessfully quited");
                                System.exit(0);
                                break;

                        }
                    } //if the Admin chooses the posts option
                    else if (userClubRelatedOperationChoice == 3) {
                        System.out.println("\n\n\n\n");
                        //prompts the user to choose between 2 options
                        System.out.println("Choose an option:");
                        System.out.println("1-See the posts for a specific clubs\n---------------------\n2-Add a post\n---------------------\n"
                                + "3-Delete a post\n---------------------\n4-Quit");
                        int userPostsAction = input.nextInt();

                        switch (userPostsAction) {
                            //if Admin chooses to see the posts for a specific Club
                            case 1:
                                //shows the current list of clubs
                                club.getClubData();
                                //prmots the Admin to enter the name od desired Club
                                input.nextLine();
                                System.out.println("What club would you like to see the post of?(enter the name)");
                                String selectedClubNameForPostDisplay = input.nextLine();
                                //calls the Club object the get the list of posts
                                club.getPosts(selectedClubNameForPostDisplay);
                                break;

                            //if the Admin chooses to insert a new post
                            case 2:
                                //shows the current list of clubs
                                club.getClubData();
                                //prmots the Admin to enter the name od desired Club
                                input.nextLine();
                                System.out.println("What club would you like to add the post to?(enter the name)");
                                String selectedClubNameForPostEntry = input.nextLine();
                                //promts the Admin to insert the post and date of posting
                                System.out.println("Please Enter the post:");
                                String postEntery = input.nextLine();
                                System.out.println("Please enter today's date (YYYY-MM-DD):");
                                String dateEntery = input.nextLine();

                                //calls the Club object to insert the post
                                club.addPost(selectedClubNameForPostEntry, postEntery, dateEntery);
                                break;

                            //if the Admin chooses to insert a new post
                            case 3:
                                //shows the current list of clubs
                                club.getClubData();
                                //prmots the Admin to enter the name od desired Club
                                input.nextLine();
                                System.out.println("What club would you like to delete the posts from?(enter the name)");
                                String selectedClubNameForPostDelete = input.nextLine();

                                //shows the posts of the Club
                                club.getPostsWithId(selectedClubNameForPostDelete);

                                System.out.println("Enter the id of the posts you would like to delete:");
                                int deletePostId = input.nextInt();

                                club.deletePost(selectedClubNameForPostDelete, deletePostId);

                                break;
                            //if quit
                            case 4:
                                System.out.println("\n\nSuccessfully quited");
                                System.exit(0);
                                break;

                        }
                     //if quit
                    } else if (userClubRelatedOperationChoice == 4) {

                        System.out.println("\n\nSuccessfully quited");
                        System.exit(0);
                        
                    }

                } //if the Admin chooses to adjust admins
                else if (userOperationChoice == 2) {
                    System.out.println("\n\n\n\n");
                    //promts the Admin to choose between 3 options
                    System.out.println("Choose an option:");
                    System.out.println("1-Change Password\n---------------------\n2-Add a new admin\n---------------------\n3-Delete an admin\n---------------------\n4-Quit");
                    int userAdminAction = input.nextInt();
                    input.nextLine();
                    switch (userAdminAction) {

                        //if the Admin chooses to change the password
                        case 1:

                            //calls the Admin object to change the pass
                            admin.changePassword();

                            break;

                        //if the Admin chooses to add a new Admin
                        case 2:
                            //calls the Admin object to show the current list of admins
                            admin.getAdminList();

                            //calls the Admin object to insert a new Admin
                            admin.addAdmin();
                            break;

                        //if the Admin chooses to delete a Admin
                        case 3:
                            //calls the Admin object to show the current list of admins
                            admin.getAdminList();

                            //calls the Admin object to delete an Admin
                            admin.deleteAdmin();
                            break;
                        
                        //if quit
                        case 4:
                            System.out.println("\n\nSuccessfully quited");
                            System.exit(0);
                            break;

                    }
                //if quit
                } else if (userOperationChoice == 3) {
                    System.out.println("\n\nSuccessfully quited");
                    System.exit(0);

                }

                System.out.println("Would you like to continue");

                contin = input.next();

            } while (contin.equalsIgnoreCase(
                    "yes"));

        }

    }
}
