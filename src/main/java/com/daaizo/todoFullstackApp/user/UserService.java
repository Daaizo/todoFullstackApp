package com.daaizo.todoFullstackApp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userByLogin = userRepository.findUserByLogin(user.getLogin());
        if (userByLogin.isPresent()) {
            throw new IllegalStateException("user with that login already exists");
        }
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        checkIfUserExist(id);
        userRepository.deleteById(id);
    }

    @Transactional
    public void updateUser(Long id, String newName, String newLogin) {
        User user = checkIfUserExist(id);
        if (newName != null && !newName.equals(user.getName())) {
            user.setName(newName);
        }
        if (newLogin != null && !newLogin.equals(user.getLogin())) {
            Optional<User> userWithNewLogin = userRepository.findUserByLogin(newLogin);
            if (userWithNewLogin.isPresent()) {
                throw new IllegalStateException("login is taken");
            }
            user.setLogin(newLogin);
        }
    }

    User checkIfUserExist(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new IllegalStateException("user with id = " + id + " does not exists");
        }
        return user.get();
    }

}
