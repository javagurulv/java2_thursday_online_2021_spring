package hr_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HumanResourcesSystemApp {
    public static void main(String[] args) {
        List <Employee> employeeList = new ArrayList <>();

        while (true) {
            System.out.println("Program menu:");
            System.out.println("1. Add new employee to list");
            System.out.println("2. Delete employee data from list");
            System.out.println("3. Show all employees in the list");
            System.out.println("4. Exit");

            System.out.println("***");

            System.out.println("Enter menu item number to execute:");
            Scanner scanner = new Scanner(System.in);
            int userChoice = Integer.parseInt(scanner.nextLine());

            switch (userChoice) {
                case 1: {
                    System.out.println("Enter employee name: ");
                    String employeeName = scanner.nextLine();
                    System.out.println("Enter employee age: ");
                    int employeeAge = Integer.parseInt(scanner.nextLine());
                    Employee employee = new Employee(employeeName, employeeAge);
                    employeeList.add(employee);
                    System.out.println("New employee was added to list.");
                    break;
                }
                case 2: {
                    System.out.println("Enter employee name: ");
                    String employeeName = scanner.nextLine();
                    System.out.println("Enter employee age: ");
                    int employeeAge = Integer.parseInt(scanner.nextLine());
                    employeeList.remove(new Employee(employeeName, employeeAge));
                    System.out.println("hr_system.Employee data were removed from list.");
                    break;
                }
                case 3: {
                    System.out.println("hr_system.Employee list: ");
                    for (Employee employee : employeeList) {
                        System.out.println(employee);
                    }
                    System.out.println("---End of employee list.---");
                    break;
                }
                case 4: {
                    System.out.println("Good bye!");
                    System.exit(0);
                }
            }
            System.out.println("----------------------------------");
        }

    }

}
