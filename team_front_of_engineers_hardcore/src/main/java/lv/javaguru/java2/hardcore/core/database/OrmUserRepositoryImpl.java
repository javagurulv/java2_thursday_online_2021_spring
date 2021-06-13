package lv.javaguru.java2.hardcore.core.database;

import lv.javaguru.java2.hardcore.core.domain.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class OrmUserRepositoryImpl implements UserRepository{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public Optional<User> getUserByLogin(String name){
        Query query = sessionFactory.getCurrentSession().createQuery(
                "SELECT b FROM User b WHERE name = :name");
        query.setParameter("name", name);
        List<User> users = query.getResultList();
        if(users.size()>1){
            System.out.println("\nSystem found more than one unique account!");
            return Optional.empty();
        }else if(users.size() == 1){
            return Optional.of(users.get(0));
        }else{
            System.out.println("\nNo such login in database!");
            return Optional.empty();
        }
    }

    @Override
    public List<User> getAllUsers() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT b FROM User b", User.class)
                .getResultList();
    }
}
