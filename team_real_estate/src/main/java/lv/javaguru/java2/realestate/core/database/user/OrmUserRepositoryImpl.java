package lv.javaguru.java2.realestate.core.database.user;

import lv.javaguru.java2.realestate.core.database.offer.UserRepository;
import lv.javaguru.java2.realestate.core.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.util.List;

@Component
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
                .createQuery("SELECT u FROM registered_user u " +
                        "WHERE username = :username AND password = :password", User.class)
                .setParameter("username", user.getUsername())
                .setParameter("password", user.getPassword())
                .getResultList();

        return userAtGivenCredentials.size() == 1;
    }

    @Override
    public boolean deleteUser(User user) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("DELETE registered_user " +
                        "WHERE username = :username AND password = :password");
        query.setParameter("username",user.getUsername());
        query.setParameter("password",user.getPassword());
        int result = query.executeUpdate();
        return result == 1;
    }
}
