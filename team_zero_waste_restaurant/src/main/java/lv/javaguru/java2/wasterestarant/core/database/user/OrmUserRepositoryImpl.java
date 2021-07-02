package lv.javaguru.java2.wasterestarant.core.database.user;

import java.util.List;
import java.util.Optional;

import lv.javaguru.java2.wasterestarant.core.domain.User;
import lv.javaguru.java2.wasterestarant.core.domain.UserRole;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class OrmUserRepositoryImpl implements UserRepository {

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
                .createQuery("SELECT u FROM User u", User.class)
                .getResultList();
    }

    @Override
    public List<User> findUserById(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "SELECT u FROM User u WHERE id = :id");
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public List<User> findUserByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "SELECT u FROM User u WHERE name = :name");
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List<User> findUserBySurname(String surname) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "SELECT u FROM User u WHERE surname = :surname");
        query.setParameter("surname", surname);
        return query.getResultList();
    }

    @Override
    public List<User> findUserByEmail(String email) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "SELECT u FROM User u WHERE email = :email");
        query.setParameter("email", email);
        return query.getResultList();
    }

    @Override
    public boolean changeUserPassword(String email) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("UPDATE User SET password = :password WHERE email = :email")
                .setParameter("email", email);
        return query.executeUpdate() == 1;
    }

    @Override
    public boolean changeUserRole(UserRole userRole, String email) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("UPDATE User SET user_role = :user_role WHERE email = :email")
                .setParameter("user_role", userRole);
        return query.executeUpdate() == 1;
    }

    @Override
    public boolean isUserRegistered(String email, String password) {
        List<User> checkedUsers = sessionFactory.getCurrentSession()
                .createQuery("SELECT u FROM User u WHERE email = :email AND password = :password", User.class)
                .setParameter("email", email)
                .setParameter("password", password)
                .getResultList();
        return checkedUsers.size() == 1;
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        Query query = sessionFactory
                .getCurrentSession()
                .createQuery("SELECT u FROM User u WHERE email = :email and password = :password");
        query.setParameter("email", email);
        query.setParameter("password", password);
        return (User) query.getSingleResult();
    }

    @Override
    public boolean isEmailRegistered(String email) {
        List<User> checkedUsers = sessionFactory.getCurrentSession()
                .createQuery("SELECT u FROM User u WHERE email = :email", User.class)
                .setParameter("email", email)
                .getResultList();
        return checkedUsers.size() == 1;
    }

    @Override
    public boolean hasUserRightsToChangeRole(User user) {
        List<User> checkedUsers = sessionFactory.getCurrentSession()
                .createQuery("SELECT u FROM User u WHERE user_role = :user_role AND email = :email AND password = :password", User.class)
                .setParameter("user_role", user.getUserRole())
                .setParameter("email", user.getEmail())
                .setParameter("password", user.getPassword())
                .getResultList();
        return checkedUsers.size() == 1;
    }

    @Override
    public List<User> findUserByRole(String role) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "SELECT u FROM User u WHERE user_role = :user_role");
        query.setParameter("user_role", role);
        return query.getResultList();
    }
}
