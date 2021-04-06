package hr_system.database;

import hr_system.bean.Employee;

import java.util.ArrayList;
import java.util.List;

public class DatabaseImpl implements Database{

    private Long nextIdEmployee = 1L;
    private List <Employee> employeeList = new ArrayList<>();

    @Override
    public void saveEmployee(Employee employee) {

        employee.setId(nextIdEmployee);
        nextIdEmployee++;
        employeeList.add(employee);

    }

    @Override
    public void deleteEmployee(Long id) {

        employeeList.stream().filter(employee -> employee.getId().equals(id))
                .findFirst().
                ifPresent(employeeList::remove);

    }

    @Override
    public List<Employee> getAllEmployees() {

        return employeeList;

    }
}
