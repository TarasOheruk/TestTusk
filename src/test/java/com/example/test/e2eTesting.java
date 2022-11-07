package com.example.test;

import com.example.test.DTO.UserNameAgeDTO;
import com.example.test.Model.User;
import com.example.test.Repository.UserRepo;
import com.example.test.Service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

public class e2eTesting {

    @Autowired
    private MockMvc mockMvc;


    private UserServiceImpl userService;
    private UserRepo userRepo;
    private User user;
    private UserNameAgeDTO userNameAgeDTO;

    @BeforeEach
    public void setup(){

        user = new User(1L,"Ramesh", LocalDate.of(2002,06,06));
        userNameAgeDTO = new UserNameAgeDTO(1L,"Ramesh",20);

    }

    @Test
    void GetUserNameAge() throws Exception {

        userRepo.save(user);
        when(userService.UserAgeByIdDTO(userNameAgeDTO.getId())).thenReturn(userNameAgeDTO);



        mockMvc.perform(MockMvcRequestBuilders
                      .get("/user/1")
                      .contentType(MediaType.APPLICATION_JSON))
                      .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
