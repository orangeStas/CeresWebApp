package by.bsuir.ceres.service;

import by.bsuir.ceres.bean.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUserById(Long id);
    void createUser(User user);
    void updateUserById(User user);
    void deleteUserById(Long id);
}