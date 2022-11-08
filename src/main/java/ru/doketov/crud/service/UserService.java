package ru.doketov.crud.service;

import org.springframework.stereotype.Service;
import ru.doketov.crud.model.User;

import java.util.List;

/**
 * {@link Service} for handling {@link User} entity
 */
public interface UserService {
    public User getUserById(Long id);

    public List<User> getAllUsers();

    public void addUser(User user);

    public void deleteUser(User user);

    public void updateUser(User user);
}
