package com.example.test.Controller;

import com.example.test.DTO.UserNameAgeDTO;
import com.example.test.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user",produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping(value = "{id}")
    public UserNameAgeDTO getUserById(@PathVariable(value = "id") Long id) {

        return userService.UserAgeByIdDTO(id);

    }
}
