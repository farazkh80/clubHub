package clubhub;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ClubHub {

    public static void main(String[] args) {

        int id;
        String name;
        int size;
        String manager;
        String location;
        String contin= "yes";

        club test = new club();
        Scanner input = new Scanner(System.in);
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
            
            contin= input.next();

        } while (contin.equalsIgnoreCase("yes"));

    }

}
