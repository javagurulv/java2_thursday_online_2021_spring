package lv.javaguru.java2.realestate.core.database.user;

import lv.javaguru.java2.realestate.core.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class OrmUserRepositoryImpl implements UserRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createAccount(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public boolean logIn(User user) {
        List<User> userAtGivenCredentials = sessionFactory.getCurrentSession()
                .createQuery("SELECT u FROM User u " +
                        "WHERE username = :username AND password = :password", User.class)
                .setParameter("username", user.getUsername())
                .setParameter("password", user.getPassword())
                .getResultList();

        return userAtGivenCredentials.size() == 1;
    }

    @Override
    public boolean deleteUser(User user) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("DELETE User " +
                        "WHERE username = :username AND password = :password");
        query.setParameter("username", user.getUsername());
        query.setParameter("password", user.getPassword());
        int result = query.executeUpdate();
        return result == 1;
    }

    @Override
    public User getUser(User user) {
        List<User> userAtGivenCredentials = sessionFactory.getCurrentSession()
                .createQuery("SELECT u FROM User u " +
                        "WHERE username = :username AND password = :password", User.class)
                .setParameter("username", user.getUsername())
                .setParameter("password", user.getPassword())
                .getResultList();

        return userAtGivenCredentials.get(0);
    }
}
