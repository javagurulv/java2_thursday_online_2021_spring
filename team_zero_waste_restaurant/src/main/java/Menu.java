import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        List<Dish> menu = new ArrayList<>();
        LinkedList<Dish> wishList = new LinkedList<Dish>();
        printProgramMenu();
        int menuNumber = getMenuNumberFromUser();
        menuItems(menu, wishList, menuNumber);
    }

    private static void printProgramMenu() {
        System.out.println();
        System.out.println("Program menu:");
        System.out.println("1. Show full restaurant menu list");
        System.out.println("2. Add dish to wishlist");
        System.out.println("3. Show wishlist");
        System.out.println("4. Exit");
        System.out.println();
    }

    private static int getMenuNumberFromUser() {
        System.out.println("Enter menu item number to execute:");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    private static void menuItems(List<Dish> menu, List<Dish> wishList, int number) {
        switch (number) {
            case 1 -> {
                showRestaurantMenu(menu);
                break;
            }
            case 2 -> {
                addDishToWishList(menu, wishList);
                break;
            }
            case 3 -> {
                showWishList(wishList);
                break;
            }
            default -> System.exit(0);
        }
    }

    private static void showWishList(List<Dish> wishList) {
        for (Dish dish : wishList) {
            System.out.println(dish);
        }
    }

    private static void showRestaurantMenu(List<Dish> menu) {
        for (Dish dish : menu) {
            System.out.println(dish);
        }
    }

    private static void addDishToWishList(List<Dish> menu, List<Dish> wishList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter name of the dish");
        String name = scanner.nextLine();
        Dish dish = new Dish(name);
        if(menu.contains(dish)){
            wishList.add(dish);
        }else{
            System.out.println("We don't have such a dish in our menu");
        }
    }
}
