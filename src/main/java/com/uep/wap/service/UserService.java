package com.uep.wap.service;

import com.uep.wap.dto.UserDTO;
import com.uep.wap.model.userTypes.User;
import com.uep.wap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void login(User user) {
        // Logic for login
    }

    public void logout(User user) {
        // Logic for logout
    }

    public void changePass(User user) {
        // Logic for changing password
    }

    public void viewPages(User user) {
        // Logic for viewing pages
    }

    public UserDTO getUserById(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setUsername(user.getUsername());
            return userDTO;
        }
        return null;
    }


    // Other methods related to user management
}