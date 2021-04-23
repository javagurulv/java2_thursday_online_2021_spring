//package lv.javaguru.java2.wasterestarant.console_ui.Wishlist;
//
//import lv.javaguru.java2.wasterestarant.console_ui.UIAction;
//import lv.javaguru.java2.wasterestarant.core.requests.Wishlist.AddDishToWishlistRequest;
//import lv.javaguru.java2.wasterestarant.core.services.Wishlist.AddDishToWishlistService;
//
//import java.util.Scanner;
//
////Nataliya
//
//public class AddDishToWishlistUIAction implements UIAction {
//
//    private AddDishToWishlistService addDishToWishlistService;
//
//    public AddDishToWishlistUIAction(AddDishToWishlistService addDishToWishlistService) {
//        this.addDishToWishlistService = addDishToWishlistService;
//    }
//
//    @Override
//    public void execute() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter dish name: ");
//        String dishName = scanner.nextLine();
//        System.out.println("Enter amount for chosen dish: ");
//        int dishQuantity = scanner.nextInt();
//        AddDishToWishlistRequest request = new AddDishToWishlistRequest(dishName, dishQuantity);
//        addDishToWishlistService.execute(request);
//        System.out.println("New dish was added to wishlist.");
//    }
//}
