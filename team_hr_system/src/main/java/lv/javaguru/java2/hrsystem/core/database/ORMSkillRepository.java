package lv.javaguru.java2.hrsystem.core.database;

import lv.javaguru.java2.hrsystem.core.domain.Skill;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ORMSkillRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Skill> getAllExistingSkills() {
        return sessionFactory.getCurrentSession().createQuery("SELECT s FROM Skill s", Skill.class)
                .getResultList();
    }

    public Long getSkillIdByName(String skillName) {
        return (Long) sessionFactory.getCurrentSession().createQuery("SELECT id FROM Skill s where skill_name = :skill_name")
                .getResultList().get(0);
    }

    //TO-DO
   /* public Set<Skill> getAllEmployeeSkills(Employee employee) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "SELECT s FROM Skill s INNER JOIN "
        )
    }*/
}