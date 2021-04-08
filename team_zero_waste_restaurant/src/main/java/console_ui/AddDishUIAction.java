package console_ui;

import database.Database;
import domain.Product;
import services.AddDishService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AddDishUIAction implements UIAction {

    private Database database;

    private AddDishService addDishService;

    public AddDishUIAction(AddDishService addDishService) {
        this.addDishService = addDishService;
    }

    @Override
    public void execute() {
        String dishName = enterDishName();
        String dishDescription = enterDishDescription();
        String dishType = enterDishType();
        double dishWeight = enterDishWeight();
        double dishPrice = enterDishPrice();

        List<Product> productList = new ArrayList<>();
        productList = traceThrowableError(productList);

        addDishService.execute(dishName, dishDescription, dishType, dishWeight, dishPrice, productList);
        System.out.println("New dish was added to the list.");
    }

    private List<Product> traceThrowableError(List<Product> productList) {
        try {
            productList = enterProductList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }

    private static String enterDishName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter dish name: ");
        String dishName = scanner.nextLine();
        return dishName;
    }

    private static String enterDishDescription() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter dish description: ");
        String dishDescription = scanner.nextLine();
        return dishDescription;
    }

    private static String enterDishType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter dish type: ");
        String dishType = scanner.nextLine();
        return dishType;
    }

    private static List<Product> enterProductList() throws ParseException {
        List<Product> productList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        try {
            while (isRunning) {
                System.out.println("Enter product name: ");
                String name = scanner.nextLine();
                System.out.println("Enter product quantity: ");
                int quantity = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter product price: ");
                double price = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter product expiry date in the format - date, month, year: ");
                DateFormat format = new SimpleDateFormat("dd, MM, yyyy", Locale.GERMANY);
                Date expiryDate = format.parse(scanner.nextLine());
                Product product1 = new Product(name, quantity, price, expiryDate);
                productList.add(product1);
                System.out.println("Product has been added to product list");
                System.out.println("Enter exit to exit program");
                String exit = scanner.nextLine();
                if(exit.equalsIgnoreCase("exit")) break;
            }
            } catch(Exception e){
                System.out.println("Error! Product hasn't been added to product list");
            }

        return productList;
    }

    private static double enterDishWeight() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter dish weight: ");
        double dishWeight = 0;
        dishWeight = doubleValueValidation(scanner, dishWeight);
        return dishWeight;
    }

    private static double enterDishPrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter dish price: ");
        double dishPrice = 0;
        dishPrice = doubleValueValidation(scanner, dishPrice);
        return dishPrice;
    }

    private static double doubleValueValidation(Scanner scanner, double value) {
        while (value <= 0)
            try {
                value = scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("Enter a valid Double value: ");
                scanner.next();
            }
        return value;
    }

}
