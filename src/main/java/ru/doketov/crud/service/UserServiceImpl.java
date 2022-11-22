package ru.doketov.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.doketov.crud.dao.UserDao;
import ru.doketov.crud.model.User;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Implementation of {@link UserService}
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
