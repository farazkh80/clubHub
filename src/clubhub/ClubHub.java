
package clubhub;

import java.util.Scanner;

public class ClubHub {

    public static void main(String[] args) {

        adminEngine operation = new adminEngine();
        clientEngine coperation = new clientEngine();
        Scanner input = new Scanner(System.in);

        System.out.println("Select one of the above:\n1-Admin Login\n2-Client use");
        int userChoice = input.nextInt();
        if (userChoice == 1) {

            operation.operationsList();

        } else if (userChoice == 2) {
            
            coperation.clientOperations();
                    
                    

        }
    }

}
