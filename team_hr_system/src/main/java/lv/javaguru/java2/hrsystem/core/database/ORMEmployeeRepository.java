package lv.javaguru.java2.hrsystem.core.database;

import lv.javaguru.java2.hrsystem.core.domain.Employee;
import lv.javaguru.java2.hrsystem.core.domain.EmployeeTitle;
import lv.javaguru.java2.hrsystem.core.domain.Skill;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Component
@Transactional
public class ORMEmployeeRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Long saveEmployee(Employee employee) {
        return (long) sessionFactory.getCurrentSession().save(employee);
    }

    public boolean deleteEmployee(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "delete Employee where id = :id");
        query.setParameter("id", id);
        int result = query.executeUpdate();
        return result == 1;
    }

    public List<Employee> getAllEmployees() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT e FROM Employee e", Employee.class)
                .getResultList();
    }

    public List<Employee> getEmployeesByTitle(EmployeeTitle title) {
        String emplTitle = title.getName();
        Query query = sessionFactory.getCurrentSession().createQuery(
                "select e FROM Employee e where employee_title = :employee_title");
        query.setParameter("employee_title", emplTitle);
        return query.getResultList();
    }

    public List<Employee> getEmployeesByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "select e FROM Employee e where first_name = :first_name");
        query.setParameter("first_name", name);
        return query.getResultList();
    }

    public List<Employee> getEmployeesByTitleAndName(EmployeeTitle title, String name) {
        String emplTitle = title.getName();
        Query query = sessionFactory.getCurrentSession().createQuery(
                "select e FROM Employee e where first_name = :first_name and employee_title = :employee_title");
        query.setParameter("first_name", name);
        query.setParameter("employee_title", emplTitle);
        return query.getResultList();
    }

    public Employee getEmployeeById(Long id) {
        return sessionFactory.getCurrentSession().get(Employee.class, id);
    }

    //add skill to existing employee
    //update DB record for employee
    public void saveEmployeeSkill(Employee employee, Skill skill) {
        Set<Skill> skills = employee.getSkills();
        Set<Employee> employees = skill.getEmployees();
        skills.add(skill);
        employees.add(employee);
       // sessionFactory.getCurrentSession().update(skill);
        sessionFactory.getCurrentSession().update(employee);
    }
}