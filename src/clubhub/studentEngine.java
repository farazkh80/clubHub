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
public class studentEngine {

    //decalring the club, and student objects.
    Scanner input = new Scanner(System.in);
    club Club = new club();
    student newStudent = new student();

    public void operations() {
        
        //variable contin to see if the user wants to continue
        String contin = "yes";
        do {
            System.out.println("\n\n");
            //promting the user to choose between 3 options available for student side.
            System.out.println("What would you like to do?\n\n1-See the list of current clubs\n---------------------\n2-Become a member to a club\n---------------------\n3-See club posts");
            int userAction = input.nextInt();

            switch (userAction) {

                //Getting and showing the list of current available clubs on the system
                case 1:

                    Club.getClubData();
                    break;

                //Showing the available clubs and asking the user information and desired club to be added to
                case 2:
                   
                    Club.getClubData();

                    //the club id is asked to increase the size of the club as the member gets added
                    System.out.println("\n\nEnter the id of the club you would like to join:");
                    int clubJoinId = input.nextInt();

                    //the club name is asked to add the student as a new member to the club.
                    input.nextLine();
                    System.out.println("Enter the name of the club you would like to join:");
                    String clubJoinName = input.nextLine();

                    //promting the user for the information about them.
                    System.out.println("What is your First Name:");
                    String fname = input.nextLine();
                    System.out.println("What is your Last Name:");
                    String lname = input.nextLine();
                    System.out.println("What is your Grade:");
                    int grade = input.nextInt();
                    System.out.println("What is your student Number:");
                    int studentNum = input.nextInt();

                    //adds the student to the club
                    newStudent.addMember(clubJoinName, fname, lname, grade, studentNum);

                    //increase the club size as the member gets added.
                    Club.memberAdded(clubJoinId);

                    break;

                //showing a specific club newsletter(page) with the latest posts
                case 3:
                    //showing all the available clubs for the user
                    Club.getClubData();

                    //asking the user to choose the club they want to see the newsletter of
                    input.nextLine();
                    System.out.println("What club would you like to see the post of?(enter the name)");
                    String selectedClubNameForPostDisplay = input.nextLine();

                    //displaying the newsletter
                    Club.getPosts(selectedClubNameForPostDisplay);
                    break;
            }
            //asking the user if they would like to continue
            System.out.println("Would you like to continue");

            contin = input.next();
        } while (contin.equalsIgnoreCase("yes")); //continues operations untill the user doesn't want to do so

    }
}
