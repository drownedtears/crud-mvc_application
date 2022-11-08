package ru.doketov.crud.dao;

import org.springframework.stereotype.Repository;
import ru.doketov.crud.model.User;

import java.util.List;

/**
 * {@link Repository} for work with crud
 */
public interface UserDao {
    public User getUserById(Long id);

    public List<User> getAllUsers();

    public void addUser(User user);

    public void deleteUser(User user);

    public void updateUser(User user);
}
