package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    User getUserById(int id);

    void saveNewUser(User user);

    void update(int id, User user);

    void delete(int id);
}
