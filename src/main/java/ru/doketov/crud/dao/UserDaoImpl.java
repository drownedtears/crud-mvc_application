package ru.doketov.crud.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.doketov.crud.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Implementation of {@link UserDao}
 */
@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        Query q = entityManager.createQuery("from User", User.class);
        return q.getResultList();
    }

    @Override
    public void addUser(User user) {
       entityManager.persist(user);
    }

    @Override
    public void deleteUser(User user) {
        entityManager.remove(user);
    }

    @Override
    public void updateUser(User user) {
        User newUser = entityManager.find(User.class, user.getId());
        entityManager.detach(newUser);
        newUser.setName(user.getName());
        newUser.setLastName(user.getLastName());
        newUser.setSalary(user.getSalary());
        entityManager.merge(newUser);
    }
}
