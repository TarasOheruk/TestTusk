package com.example.test;

import com.example.test.Model.User;
import com.example.test.Repository.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)

public class UserTest {

    @Autowired
    private UserRepo userRepo;

    @Test
    public void testCreateUser()
    {
        User user = new User();
        user.setName("Taras");
        LocalDate date = LocalDate.of(2002, 2, 6);
        user.setDate(date);

        userRepo.save(user);
    }



}
