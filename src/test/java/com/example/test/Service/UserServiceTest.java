package com.example.test.Service;

import com.example.test.DTO.UserNameAgeDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    private UserNameAgeDTO userNameAgeDTO;

    @BeforeEach
    public void setup(){

        userNameAgeDTO = new UserNameAgeDTO(1L,"Ramesh",20);

    }
    @Test
    void userAgeDTO() {

        UserServiceImpl userService = mock(UserServiceImpl.class);
        when(userService.UserAgeByIdDTO(1L)).thenReturn(userNameAgeDTO);

        UserNameAgeDTO userNameAgeDTO1 = userService.UserAgeByIdDTO(1L);

        assertThat(userNameAgeDTO1).isNotNull();
        assertThat(userNameAgeDTO1.getAge()).isEqualTo(20);
        assertThat(userNameAgeDTO1.getName()).isEqualTo("Ramesh");
    }
    @Test
    void userAgeById() {

        UserServiceImpl userService = mock(UserServiceImpl.class);
        when(userService.AgeOfUserById(3L)).thenReturn(20);

        Integer i = userService.AgeOfUserById(3L);

        assertThat(userService.AgeOfUserById(3L)).isEqualTo(i);

    }

}