package clubhub;

import java.util.Scanner;

public class ClubHub {

    public static void main(String[] args) {

        Operations operation = new Operations();
        Scanner input = new Scanner(System.in);

        System.out.println("Select one of the above:\n1-Admin Login\n2-Client use");
        int userChoice = input.nextInt();
        if (userChoice == 1) {

            operation.operationsList();

        } else if (userChoice == 2) {

        }
    }

}
