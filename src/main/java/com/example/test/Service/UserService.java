package com.example.test.Service;

import com.example.test.DTO.UserNameAgeDTO;

public interface UserService {

    public Integer AgeOfUserById(Long id);
    public UserNameAgeDTO UserAgeByIdDTO (Long id);

}
