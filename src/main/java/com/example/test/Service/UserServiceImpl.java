package com.example.test.Service;

import com.example.test.DTO.UserNameAgeDTO;
import com.example.test.Model.User;
import com.example.test.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


@Service
public class UserServiceImpl implements UserService{


    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Integer AgeOfUserById(Long id) {

        LocalDate current = LocalDate.now();
        Integer diff = Math.toIntExact(ChronoUnit.YEARS.between(userRepo.findById(id).get().getDate(), current));
        return diff;

    }

    @Override
    public UserNameAgeDTO UserAgeByIdDTO (Long id) {

        User userData = userRepo.findById(id).get();

        UserNameAgeDTO dto = new UserNameAgeDTO();

        dto.setId(userData.getId());
        dto.setName(userData.getName());
        dto.setAge(AgeOfUserById(userData.getId()));

        return dto;
    }


}
