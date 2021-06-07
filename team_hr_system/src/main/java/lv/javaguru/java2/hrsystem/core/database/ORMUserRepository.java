package lv.javaguru.java2.hrsystem.core.database;

import lv.javaguru.java2.hrsystem.core.domain.User;
import org.hibernate.SessionFactory;


public class ORMUserRepository {

    //@Autowired
    private SessionFactory sessionFactory;

    public void registerUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

}