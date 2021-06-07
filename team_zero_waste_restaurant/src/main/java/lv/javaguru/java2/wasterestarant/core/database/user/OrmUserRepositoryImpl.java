package lv.javaguru.java2.wasterestarant.core.database.user;

import java.util.List;

import lv.javaguru.java2.wasterestarant.core.domain.User;
import lv.javaguru.java2.wasterestarant.core.domain.UserRole;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class OrmUserRepositoryImpl implements UserRepository{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public boolean deleteUserById(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "DELETE User WHERE id = :id");
        query.setParameter("id", id);
        int result = query.executeUpdate();
        return result == 1;
    }

    @Override
    public List<User> getAllUsers() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT b FROM User b", User.class)
                .getResultList();
    }

    @Override
    public List<User> findUserById(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "SELECT b FROM User b WHERE id = :id");
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public List<User> findUserByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "SELECT b FROM User b WHERE name = :name");
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List<User> findUserBySurname(String surname) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "SELECT b FROM User b WHERE surname = :surname");
        query.setParameter("surname", surname);
        return query.getResultList();
    }

    @Override
    public List<User> findUserByEmail(String email) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "SELECT b FROM User b WHERE email = :email");
        query.setParameter("email", email);
        return query.getResultList();
    }

    @Override
    public List<UserRole> findUserByRole(String role) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "SELECT b FROM User b WHERE role = :role");
        query.setParameter("role", role);
        return query.getResultList();
    }
}
