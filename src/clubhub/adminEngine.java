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

    //decalring the objects
    admin Admin = new admin();
    Scanner input = new Scanner(System.in);
    club Club = new club();
    student newStudent = new student();

    //method to handle admin opreations
    public void operations() {

        //if admin login is successful runs the code
        if (Admin.checkAdmin()) {

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
                System.out.println("1-Club Related\n2-Admin Related");
                int userOperationChoice = input.nextInt();
                //if clubs runs the code 
                if (userOperationChoice == 1) {
                    System.out.println("\n\n\n\n");
                    System.out.println("What type of data you would like to work on?");
                    System.out.println("1-Club Information Related\n---------------------\n2-Club Members Related\n---------------------\n3-Club Posts Related");
                    int userClubRelatedOperationChoice = input.nextInt();

                    if (userClubRelatedOperationChoice == 1) {
                        System.out.println("\n\n\n\n");
                        //prompts the user to choose between 4 options
                        System.out.println("Choose an option:");
                        System.out.println("1-Insert a new Club\n---------------------\n2-Get the list of current clubs\n---------------------\n3-Update a club\n---------------------\n4-Delete a club");
                        int userClubInformationAction = input.nextInt();

                        switch (userClubInformationAction) {

                            //if admin chooses to insert a club
                            case 1:

                                //gets the inforamtion for the new club
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

                                //calls the club object to add a new club, create a member table and a post table for the club name
                                Club.addClub(name, size, manager, location);
                                Club.createClubTable(name);
                                Club.createClubTableForPosts(name);

                                break;

                            //if admin chooses to get the club list
                            case 2:

                                //calls the club object to get the current club list
                                Club.getClubData();
                                break;

                            //if admin chooses to update a club information
                            case 3:
                                //shows the club list first
                                System.out.println("See the list of clubs first");
                                Club.getClubData();
                                //promts the admin for the id of the desired club
                                System.out.print("Enter the id of the club you would like to update: ");
                                id = input.nextInt();

                                //asks what information they would like to update
                                System.out.println("What would you like to update: ");
                                System.out.println("1-Name\n2-Size\n3-Manager\n4-Location");
                                int userUpdateChoice = input.nextInt();
                                switch (userUpdateChoice) {

                                    //if it is to change the name of the club
                                    case 1:
                                        //promts the user for the new name
                                        input.nextLine();
                                        System.out.println("Enter the new NAME: ");
                                        name = input.nextLine();
                                        //calls the club obj to change the name
                                        Club.changeName(id, name);
                                        break;

                                    //if it is to change the size of the club
                                    case 2:
                                        //promts the user for the new size
                                        input.nextLine();
                                        System.out.println("Enter the new SIZE: ");
                                        size = input.nextInt();
                                        //calls the club obj to change the size
                                        Club.changeSize(id, size);
                                        break;

                                    //if it is to change the manager of the club
                                    case 3:
                                        //promts the user for the new manager
                                        input.nextLine();
                                        System.out.println("Enter the new MANAGER: ");
                                        manager = input.nextLine();
                                        //calls the club obj to change the manager
                                        Club.changeManager(id, manager);
                                        break;

                                    //if it is to change the location of the club
                                    case 4:
                                        //promts the user for the new location
                                        input.nextLine();
                                        System.out.println("Enter the new Location: ");
                                        location = input.nextLine();
                                        //calls the club obj to change the location
                                        Club.changeLocation(id, location);
                                        break;

                                }
                                break;

                            //if admin chooses to delete a club
                            case 4:
                                //shows the current club list first
                                Club.getClubData();

                                //prompts the admin for the id of the desired club
                                System.out.println("What is the id of the club you would like to delete?");
                                int userIdEntry = input.nextInt();
                                //prompts the admin for the id of the desired club again
                                input.nextLine();
                                System.out.println("What is the name of the club you would like to delete?");
                                String userNameEntry = input.nextLine();
                                //asks if they of sure of deleting
                                System.out.println("Are you sure of deleting " + userNameEntry + " with the id of " + userIdEntry + " ?");
                                String userAnswer = input.next();
                                //if yes runs the code
                                if (userAnswer.equalsIgnoreCase("yes")) {

                                    if (Admin.checkPassword()) {

                                        //calls the club object to delete the club from club list using its id
                                        Club.deleteClub(userIdEntry);

                                        //calls the club object to delete the member and posts tables for the club using its name
                                        Club.deleteClubTable(userNameEntry);
                                    } else {
                                        //if no shows failed message
                                        System.out.println("failed to delete");

                                    }
                                }
                                break;
                        }
                    } //if the admin chooses the member option
                    else if (userClubRelatedOperationChoice == 2) {
                        System.out.println("\n\n\n\n");
                        //prompts the user to choose between 1 options
                        System.out.println("Choose an option:");
                        System.out.println("1-Get the member list for a club\n---------------------\n2-Add a member to a Club\n---------------------\n3-Delete a member from a club");
                        int userMembersAction = input.nextInt();

                        switch (userMembersAction) {

                            //if the admin chooses to see the current list of members for a specific club
                            case 1:
                                //shows the current list of clubs
                                Club.getClubData();
                                //prmots the admin to enter the name od desired club
                                input.nextLine();
                                System.out.println("Enter the name of the club you would like to get the list of.");
                                String selectedClubName = input.nextLine();

                                //calls the club object the get the list of members
                                Club.memberList(selectedClubName);
                                break;

                            case 2:

                                Club.getClubData();

                                //the club id is asked to increase the size of the club as the member gets added
                                System.out.println("\n\nEnter the id of the club you would like to add the student to:");
                                int clubJoinMemberId = input.nextInt();

                                //the club name is asked to add the student as a new member to the club.
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

                                //adds the student to the club
                                newStudent.addMember(clubJoinMemberName, fname, lname, grade, studentNum);

                                //increase the club size as the member gets added.
                                Club.memberAdded(clubJoinMemberId);

                                break;

                            case 3:

                                Club.getClubData();

                                //the club id is asked to increase the size of the club as the member gets added
                                System.out.println("\n\nEnter the id of the club you would like to add the student to:");
                                int clubDeleteMemberId = input.nextInt();

                                //the club name is asked to add the student as a new member to the club.
                                input.nextLine();
                                System.out.println("Enter the name of the club you would like to add the student to:");
                                String clubDeleteMemberName = input.nextLine();

                                //calls the club object the get the list of members
                                Club.memberList(clubDeleteMemberName);

                                System.out.println("What is his/her student Number:");
                                int DeletestudentNum = input.nextInt();

                                newStudent.deleteMember(clubDeleteMemberName, DeletestudentNum);

                                Club.memberRemoved(clubDeleteMemberId);

                        }
                    } //if the admin chooses the posts option
                    else if (userClubRelatedOperationChoice == 3) {
                        System.out.println("\n\n\n\n");
                        //prompts the user to choose between 2 options
                        System.out.println("Choose an option:");
                        System.out.println("1-See the posts for a specific clubs\n---------------------\n2-Add a post\n---------------------\n3-Delete a post");
                        int userPostsAction = input.nextInt();

                        switch (userPostsAction) {
                            //if admin chooses to see the posts for a specific club
                            case 1:
                                //shows the current list of clubs
                                Club.getClubData();
                                //prmots the admin to enter the name od desired club
                                input.nextLine();
                                System.out.println("What club would you like to see the post of?(enter the name)");
                                String selectedClubNameForPostDisplay = input.nextLine();
                                //calls the club object the get the list of posts
                                Club.getPosts(selectedClubNameForPostDisplay);
                                break;

                            //if the admin chooses to insert a new post
                            case 2:
                                //shows the current list of clubs
                                Club.getClubData();
                                //prmots the admin to enter the name od desired club
                                input.nextLine();
                                System.out.println("What club would you like to add the post to?(enter the name)");
                                String selectedClubNameForPostEntry = input.nextLine();
                                //promts the admin to insert the post and date of posting
                                System.out.println("Please Enter the post:");
                                String postEntery = input.nextLine();
                                System.out.println("Please enter today's date (YYYY-MM-DD):");
                                String dateEntery = input.nextLine();

                                //calls the club object to insert the post
                                Club.addPost(selectedClubNameForPostEntry, postEntery, dateEntery);
                                break;

                            //if the admin chooses to insert a new post
                            case 3:
                                //shows the current list of clubs
                                Club.getClubData();
                                //prmots the admin to enter the name od desired club
                                input.nextLine();
                                System.out.println("What club would you like to delete the posts from?(enter the name)");
                                String selectedClubNameForPostDelete = input.nextLine();

                                //shows the posts of the club
                                Club.getPostsWithId(selectedClubNameForPostDelete);
                                
                                System.out.println("Enter the id of the posts you would like to delete:");
                                int deletePostId = input.nextInt();
                                
                                
                                Club.deletePost(selectedClubNameForPostDelete, deletePostId);
                                

                                break;

                        }
                    }

                } //if the admin chooses to adjust admins
                else if (userOperationChoice == 2) {
                    System.out.println("\n\n\n\n");
                    //promts the admin to choose between 3 options
                    System.out.println("Choose an option:");
                    System.out.println("1-Change Password\n2-Add a new admin\n3-Delete an admin");
                    int userAdminAction = input.nextInt();
                    input.nextLine();
                    switch (userAdminAction) {

                        //if the admin chooses to change the password
                        case 1:

                            //calls the admin object to change the pass
                            Admin.changePassword();

                            break;

                        //if the admin chooses to add a new admin
                        case 2:
                            //calls the admin object to show the current list of admins
                            Admin.getAdminList();

                            //calls the admin object to insert a new admin
                            Admin.addAdmin();
                            break;

                        //if the admin chooses to delete a admin
                        case 3:
                            //calls the admin object to show the current list of admins
                            Admin.getAdminList();

                            //calls the admin object to delete an admin
                            Admin.deleteAdmin();
                            break;

                    }
                }

                System.out.println("Would you like to continue");

                contin = input.next();

            } while (contin.equalsIgnoreCase(
                    "yes"));

        }

    }
}
