package lv.javaguru.java2.hrsystem.core.database;

import lv.javaguru.java2.hrsystem.core.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class ORMUserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void registerUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

}