package com.fundamentalsplatzi.springboot.fundamentals.caseuse;

import com.fundamentalsplatzi.springboot.fundamentals.entity.User;
import com.fundamentalsplatzi.springboot.fundamentals.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {
    private UserService userService;

    public UpdateUser(UserService userService) {
        this.userService = userService;
    }

    public User update(User newUser, Long id) {
        return userService.update(newUser, id);
    }
}
