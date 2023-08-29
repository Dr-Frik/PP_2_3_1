package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
    @Override
    @Transactional
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }
    @Override
    @Transactional
    public void saveNewUser(User user) {
        userDao.saveNewUser(user);
    }

    @Override
    @Transactional
    public void update(int id, User user) {
        userDao.update(id, user);
    }
    @Override
    @Transactional
    public void delete(int id) {userDao.delete(id);}
}