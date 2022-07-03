package com.ayush.productservice.service.impl;

import com.ayush.productservice.model.User;
import com.ayush.productservice.repo.UserRepo;
import com.ayush.productservice.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserService {
    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public Long create(User user) {
        User data = userRepo.save(user);
        return data.getId();
    }
}
