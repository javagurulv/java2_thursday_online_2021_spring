package lv.javaguru.java2.hrsystem.application;

import lv.javaguru.java2.hrsystem.console_ui.*;
import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.database.DatabaseImpl;
import lv.javaguru.java2.hrsystem.core.services.*;
import lv.javaguru.java2.hrsystem.core.services.validators.*;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {

    private Map<Class, Object> beans = new HashMap<>();

    public ApplicationContext() {
        beans.put(Database.class, new DatabaseImpl());

        beans.put(RegisterUserValidator.class, new RegisterUserValidator());
        beans.put(AuthorizeUserValidator.class, new AuthorizeUserValidator());

        beans.put(RegisterUserService.class, new RegisterUserService(
                getBean(Database.class),
                getBean(RegisterUserValidator.class)));
        beans.put(AuthorizeUserService.class, new AuthorizeUserService(
                getBean(Database.class),
                getBean(AuthorizeUserValidator.class)));
        beans.put(GetAllUsersService.class, new GetAllUsersService(
                getBean(Database.class)));

        beans.put(RegisterUserUIAction.class, new RegisterUserUIAction(getBean(RegisterUserService.class)));
        beans.put(AuthorizeUserUIAction.class, new AuthorizeUserUIAction(getBean(AuthorizeUserService.class)));
        beans.put(GetAllUsersUIAction.class, new GetAllUsersUIAction(getBean(GetAllUsersService.class)));
        beans.put(ExitUIAction.class, new ExitUIAction());


        beans.put(AddEmployeeRequestValidator.class, new AddEmployeeRequestValidator());
        beans.put(SearchEmployeesRequestValidator.class, new SearchEmployeesRequestValidator());
        beans.put(AddSkillRequestValidator.class, new AddSkillRequestValidator());
        beans.put(SearchEmployeesBySkillRequestValidator.class, new SearchEmployeesBySkillRequestValidator());

        beans.put(AddEmployeeService.class, new AddEmployeeService(
                getBean(Database.class),
                getBean(AddEmployeeRequestValidator.class)));
        beans.put(AddEmployeeWithTitleService.class, new AddEmployeeWithTitleService(
                getBean(Database.class)));
        beans.put(DeleteEmployeeService.class, new DeleteEmployeeService(
                getBean(Database.class)));
        beans.put(GetAllEmployeesService.class, new GetAllEmployeesService(
                getBean(Database.class)));
        beans.put(SearchEmployeesService.class, new SearchEmployeesService(
                getBean(Database.class),
                getBean(SearchEmployeesRequestValidator.class)));
        beans.put(AddSkillService.class, new AddSkillService(
                getBean(Database.class),
                getBean(AddSkillRequestValidator.class)));
        beans.put(GetAllEmployeeSkillsService.class, new GetAllEmployeeSkillsService(
                getBean(Database.class)));
        beans.put(SearchEmployeesBySkillService.class, new SearchEmployeesBySkillService(
                getBean(Database.class),
                getBean(SearchEmployeesBySkillRequestValidator.class)));

        beans.put(AddEmployeeUIAction.class, new AddEmployeeUIAction(getBean(AddEmployeeService.class)));
        beans.put(AddEmployeeWithTitleUIAction.class, new AddEmployeeWithTitleUIAction(getBean(AddEmployeeWithTitleService.class)));
        beans.put(DeleteEmployeeUIAction.class, new DeleteEmployeeUIAction(getBean(DeleteEmployeeService.class)));
        beans.put(GetAllEmployeesUIAction.class, new GetAllEmployeesUIAction(getBean(GetAllEmployeesService.class)));
        beans.put(SearchEmployeesUIAction.class, new SearchEmployeesUIAction(getBean(SearchEmployeesService.class)));
        beans.put(AddSkillUIAction.class, new AddSkillUIAction(getBean(AddSkillService.class)));
        beans.put(GetAllEmployeeSkillUIAction.class, new GetAllEmployeeSkillUIAction(getBean(GetAllEmployeeSkillsService.class)));
        beans.put(SearchEmployeesBySkillUIAction.class, new SearchEmployeesBySkillUIAction(getBean(SearchEmployeesBySkillService.class)));

    }

    public <T extends Object> T getBean(Class c) {
        return (T) beans.get(c);
    }
}
