package lv.javaguru.java2.hrsystem.core.database;

import lv.javaguru.java2.hrsystem.core.domain.EmployeeTitle;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ORMEmployeeTitleRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public boolean saveTitle(EmployeeTitle employeeTitle) {
        return (long) sessionFactory.getCurrentSession().save(employeeTitle) != 0L;
    }

    public List<EmployeeTitle> getAllUniqueTitles() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT e FROM EmployeeTitle e", EmployeeTitle.class)
                .getResultList();
    }
}