package lv.javaguru.java2.hrsystem.core.database;

import lv.javaguru.java2.hrsystem.core.domain.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@Transactional
public class ORMAuthorizationRepository {

    @Autowired private SessionFactory sessionFactory;

    public void registerUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public Optional<User> authorizeUser(String email, String password) {
        Query query = sessionFactory
                .getCurrentSession()
                .createQuery("SELECT u FROM User u WHERE email = :email and password = :password");
        query.setParameter("email", email);
        query.setParameter("password", password);
        query.getResultList();

        return query.getResultList().stream().findFirst();
    }
}
