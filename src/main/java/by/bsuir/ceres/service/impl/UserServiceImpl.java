package by.bsuir.ceres.service.impl;

import by.bsuir.ceres.bean.User;
import by.bsuir.ceres.dao.UserRepository;
import by.bsuir.ceres.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {

        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {

        return userRepository.findOne(id);
    }

    @Override
    public void createUser(User user) {

        userRepository.save(user);
    }

    @Override
    public void updateUserById(User user) {

        userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {

        userRepository.delete(id);
    }
}
