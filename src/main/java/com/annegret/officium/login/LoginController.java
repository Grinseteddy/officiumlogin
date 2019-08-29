package com.annegret.officium.login;

import com.annegret.officium.login.Entities.*;
import lombok.extern.java.Log;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.UUID;

@RestController
public class LoginController {

    private final UserRepository userRepository;

    LoginController(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    @GetMapping("login/name")
    public UserResponse getUserByName(@RequestBody UserName userName) {
        UserEntity user=userRepository.findUserEntityByUsername(userName.getUserName());
        if (user==null) {
            Message message=new Message("USERNOTFOUND", Message.severity.ERROR,
                    "User couldn't be found", UUID.randomUUID().toString());
            return new UserResponse(null, message, null);
        } else {
            Message message=new Message("USERFOUND", Message.severity.SUCCESS,
                    "User could be found", UUID.randomUUID().toString());
            return new UserResponse(user, message, null);
        }
    }

    @GetMapping("login/emailaddress")
    public UserResponse getUserByEmailAddress(@RequestBody UserEmailAddress emailaddress) {
        UserEntity user=userRepository.findUserEntityByEmailAddress(emailaddress.geteMailAddress());
        if (user==null) {
            Message message=new Message("USERNOTFOUND", Message.severity.ERROR,
                    "User couldn't be found", UUID.randomUUID().toString());
            return new UserResponse(null, message, null);
        } else {
            Message message=new Message("USERFOUND", Message.severity.SUCCESS,
                    "User could be found", UUID.randomUUID().toString());
            return new UserResponse(user, message, null);
        }
    }
}
