package com.app.MyCoolApp.services;

import com.app.MyCoolApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public int registerNewUserServiceCall(String username, String password, String firstname, String lastname, String mobile){
        return userRepository.registerNewUser(username,password,firstname,lastname,mobile);

    }
}
