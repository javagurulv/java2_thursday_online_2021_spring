package lv.javaguru.java2.hrsystem.consoleUI_JK;

import lv.javaguru.java2.hrsystem.bean.Employee;
import lv.javaguru.java2.hrsystem.services_JK.GetAllEmployees_JK;

import java.util.List;

public class GetAllEmployeesUI implements UIAction{
    private GetAllEmployees_JK getAllEmployees_jk;

    public GetAllEmployeesUI(GetAllEmployees_JK getAllEmployees_jk) {
        this.getAllEmployees_jk = getAllEmployees_jk;
    }

    @Override
    public void perform() {
        System.out.println("Employee list: ");
        List<Employee> employees = getAllEmployees_jk.getAll();
        if (!employees.isEmpty()) {
            employees.forEach(System.out::println);
        }
        else {
            System.out.println("No employees");
        }
       // getAllEmployees_jk.getAll().forEach(System.out::println);
        System.out.println("---End of employee list.---");
    }
}