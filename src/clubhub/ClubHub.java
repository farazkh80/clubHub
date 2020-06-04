package clubhub;


import java.util.Scanner;


public class ClubHub {

    public static void main(String[] args) {

        admin admintest = new admin();
        Scanner input = new Scanner(System.in);

        System.out.println("Select one of the above:\n1-Admin Login\n2-Client use");
        int userChoice = input.nextInt();
        if (userChoice == 1) {
            if (admintest.checkAdmin() == true) {
                admintest.adminOperations();
            }
        } else if (userChoice == 2) {

        }
    }

}
