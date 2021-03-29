import java.util.ArrayList;
import java.util.List;

public class Menu {
    public static void main(String[] args) {
        List<Dish> menu = new ArrayList<>();
            printProgramMenu();

    }

    private static void printProgramMenu() {
        System.out.println();
        System.out.println("Program menu:");
        System.out.println("1. Select dish ");
        System.out.println("2. Add dish to wishlist");
        System.out.println("3. Show wishlist");
        System.out.println("4. Show full menu");
        System.out.println("5. Exit");
        System.out.println();
    }

}
