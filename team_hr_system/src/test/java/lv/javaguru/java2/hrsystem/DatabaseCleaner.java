package lv.javaguru.java2.hrsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseCleaner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void clean() {
        for(String tableName : getTableNames()) {
            String sql = "delete from " + tableName;
            jdbcTemplate.execute(sql);
        }
    }

    private List<String> getTableNames() {
        List<String> tableNames = new ArrayList<>();
        tableNames.add("employee_skills");
        tableNames.add("skills");
        tableNames.add("employees");
        tableNames.add("skills");
        tableNames.add("employee_titles");
        tableNames.add("users");
        return tableNames;
    }

}