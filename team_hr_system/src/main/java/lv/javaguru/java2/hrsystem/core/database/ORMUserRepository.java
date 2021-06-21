package lv.javaguru.java2.hrsystem.core.database;

import lv.javaguru.java2.hrsystem.core.domain.User;
import lv.javaguru.java2.hrsystem.core.domain.UserRole;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Component
@Transactional
public class ORMUserRepository {

    @Autowired private SessionFactory sessionFactory;

    public List<User> getAllUsers() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("SELECT u FROM User u", User.class)
                .getResultList();
    }

    public boolean deleteUser(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "DELETE User WHERE id = :id");
        query.setParameter("id", id);

        int result = query.executeUpdate();

        return result == 1;
    }

    public boolean updateUserRole(Long id, UserRole userRole) {

        Query query = sessionFactory.getCurrentSession()
                .createQuery("UPDATE User SET userRole = :userRole WHERE id = :id")
                .setParameter("userRole", userRole)
                .setParameter("id", id);

        return query.executeUpdate() == 1;
    }
}