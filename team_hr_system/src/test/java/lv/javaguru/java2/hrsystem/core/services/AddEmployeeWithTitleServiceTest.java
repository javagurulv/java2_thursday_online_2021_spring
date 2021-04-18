package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.database.DatabaseImpl;
import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeWithTitleRequest;
import lv.javaguru.java2.hrsystem.core.responses.AddEmployeeWithTitleResponse;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.domain.Employee;
import lv.javaguru.java2.hrsystem.domain.EmployeeTitle;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class AddEmployeeWithTitleServiceTest {
    private AddEmployeeWithTitleService addEmployeeWithTitleService;
    private Database database;

    @Test
    public void addWithValidTitle() {
        database = new DatabaseImpl();
        addEmployeeWithTitleService = new AddEmployeeWithTitleService(database);
        AddEmployeeWithTitleRequest request = new AddEmployeeWithTitleRequest("Aaa", "Bbb", 25, "BA");
        AddEmployeeWithTitleResponse response = addEmployeeWithTitleService.execute(request);
        assertThat(response.getEmployee())
                .isEqualTo(new Employee(1L, "Aaa", "Bbb", 25, EmployeeTitle.BA));
    }

    @Test
    public void addWithInValidTitle() {
        database = new DatabaseImpl();
        addEmployeeWithTitleService = new AddEmployeeWithTitleService(database);
        AddEmployeeWithTitleRequest request = new AddEmployeeWithTitleRequest("Aaa", "Bbb", 25, "BAA");
        AddEmployeeWithTitleResponse response = addEmployeeWithTitleService.execute(request);
        assertThat(response.hasErrors()).isTrue();
    }

    @Test
    public void addWithInEmptyTitle() {
        database = new DatabaseImpl();
        addEmployeeWithTitleService = new AddEmployeeWithTitleService(database);
        AddEmployeeWithTitleRequest request = new AddEmployeeWithTitleRequest("Aaa", "Bbb", 25, "");
        AddEmployeeWithTitleResponse response = addEmployeeWithTitleService.execute(request);
        assertThat(response.hasErrors()).isTrue();
    }
}