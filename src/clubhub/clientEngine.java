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
public class clientEngine {

    admin Admin = new admin();
    Scanner input = new Scanner(System.in);
    club Club = new club();
    student newStudent = new student();

    public void clientOperations() {
        String contin = "yes";
        do {
            System.out.println("What would you like to do?\n1-See the list of current clubs\n2-Become a member to a club\n3-See club posts");
            int userAction = input.nextInt();

            switch (userAction) {

                case 1:
                    Club.getClubData();
                    break;

                case 2:
                    System.out.println("Here are the all available clubs\n\n");
                    Club.getClubData();
                    System.out.println("\n\nEnter the id of the club you would like to join:");
                    int clubJoinId = input.nextInt();
                    input.nextLine();
                    System.out.println("Enter the name of the club you would like to join:");
                    String clubJoinName = input.nextLine();
                    System.out.println("What is your First Name:");
                    String fname = input.nextLine();
                    System.out.println("What is your Last Name:");
                    String lname = input.nextLine();
                    System.out.println("What is your Grade:");
                    int grade = input.nextInt();
                    System.out.println("What is your student Number:");
                    int studentNum = input.nextInt();

                    // newStudent.addMember(clubJoinName, fname, lname, grade, studentNum);
                    newStudent.addMember(clubJoinName, fname, lname, grade, studentNum);
                    Club.memberAdded(clubJoinId);

                    break;

                case 3:
                    Club.getClubData();
                    input.nextLine();
                    System.out.println("What club would you like to see the post of?(enter the name)");
                    String selectedClubNameForPostDisplay = input.nextLine();
                    Club.getPosts(selectedClubNameForPostDisplay);
                    break;
            }
            System.out.println("Would you like to continue");

            contin = input.next();
        } while (contin.equalsIgnoreCase("yes"));

    }
}
