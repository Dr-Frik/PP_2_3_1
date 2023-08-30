package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(int id);

    void saveNewUser(User user);

    void update(User user);

    void delete(int id);
}
