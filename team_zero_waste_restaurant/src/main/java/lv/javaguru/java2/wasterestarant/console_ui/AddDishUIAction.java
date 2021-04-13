package lv.javaguru.java2.wasterestarant.console_ui;

import lv.javaguru.java2.wasterestarant.core.requests.AddDishRequest;
import lv.javaguru.java2.wasterestarant.core.responses.AddDishResponse;
import lv.javaguru.java2.wasterestarant.core.services.AddDishService;

import java.util.Scanner;

public class AddDishUIAction implements UIAction {
    private AddDishService addDishService;

    public AddDishUIAction(AddDishService addDishService) {
        this.addDishService = addDishService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter dish name: ");
        String dishName = scanner.nextLine();
        System.out.println("Enter dish description: ");
        String dishDescription = scanner.nextLine();
        System.out.println("Enter dish type: ");
        String dishType = scanner.nextLine();
        System.out.println("Enter dish weight: ");
        Double dishWeight = getDouble(scanner);
        System.out.println("Enter dish price: ");
        Double dishPrice = getDouble(scanner);
        AddDishRequest request = new AddDishRequest(dishName, dishDescription, dishType, dishWeight, dishPrice);
        AddDishResponse response = addDishService.execute(request);

       /* Needs to be implemented again
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
                if (exit.equalsIgnoreCase("exit")) break;
            }
        } catch (Exception e) {
            System.out.println("Error! Product hasn't been added to product list");
        }

        return productList;
    }*/

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            System.out.println("New dish id : " + response.getNewDish().getDishID());
            System.out.println("Your dish has been added to the list");
        }
    }

    private Double getDouble(Scanner scanner) {
        try{
           return Double.parseDouble(scanner.nextLine());
        }
        catch(Exception e){
            return null;
        }
    }


}
