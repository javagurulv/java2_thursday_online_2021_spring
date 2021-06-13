package lv.javaguru.java2.hrsystem.core.database;

import lv.javaguru.java2.hrsystem.core.domain.Skill;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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

    public Long getSkillIdByName(Skill skill) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "SELECT id FROM Skill s where skill_name = :skill_name");
        query.setParameter("skill_name", skill.getSkillName());
        return (Long) query.getResultList().get(0);
    }

    public boolean saveSkill(Skill skill) {
        return (long) sessionFactory.getCurrentSession().save(skill) != 0L;
    }

    public Skill getSkillByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("SELECT s FROM Skill s " +
                "WHERE skillName =: skillName");
        query.setParameter("skillName", name);
        return  (Skill) query.getSingleResult();
    }
}