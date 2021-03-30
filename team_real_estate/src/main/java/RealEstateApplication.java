import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class RealEstateApplication {

    private final static List<Offer> offers = new ArrayList<>();
    private final static List<User> users = new ArrayList<>();
    private static boolean loggedIn = false;

    public static void main(String[] args) {
        while (true) {
            System.out.println("Choose available option : ");
            System.out.println("1. Create account ");
            System.out.println("2. Log in ");
            System.out.println("3. Create offer ");
            System.out.println("4. View all offers ");
            System.out.println("0. Exit");

            Scanner scanner = new Scanner(System.in);
            int chosenOption = Integer.parseInt(scanner.nextLine());

            if (chosenOption < 5 && chosenOption >= 0) {
                if (chosenOption == 0) {
                    System.exit(0);
                }
                if (chosenOption == 1) {
                    System.out.println("Enter username : ");
                    String username = scanner.nextLine();
                    System.out.println("Enter password : ");
                    String password = scanner.nextLine();

                    users.add(new User(username, password));
                    System.out.println("Enter email address : ");
                    users.get(users.size() - 1).setEmail(scanner.toString());
                    users.get(users.size() - 1).setId(users.size() + 1);

                    System.out.println("Account created");
                }
                if (chosenOption == 2) {
                    System.out.println("Enter username : ");
                    String username = scanner.nextLine();
                    System.out.println("Enter password : ");
                    String password = scanner.nextLine();
                    if (users.contains(new User(username, password))) {
                        loggedIn = true;
                        System.out.println("Welcome " + username);
                    }
                }
                if (chosenOption == 3) {
                    System.out.println("Enter offer type (Buy/Sell/Rent) : ");
                    String offerType = scanner.nextLine();
                    System.out.println("Enter property category (Land/House/Flat : ");
                    String propertyCategory = scanner.nextLine();
                    System.out.println("Type in offer description : ");
                    String description = scanner.nextLine();
                    System.out.println("Enter price : ");
                    int price = scanner.nextInt();

                    offers.add(new Offer(offerType, propertyCategory, description, price));
                    System.out.println("Offer created");
                }
                if (chosenOption == 4) {
                    if (loggedIn) {
                        offers.forEach(offer -> System.out.println(offer.toString()));
                    }
                }
            }
        }
    }
}
