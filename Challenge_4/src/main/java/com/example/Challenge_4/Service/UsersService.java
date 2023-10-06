package com.example.Challenge_4.Service;

import com.example.Challenge_4.Model.Users;
import org.springframework.stereotype.Service;

@Service
public interface UsersService {
    Users addUser(Users users);
    void deleteUser(String UserId);
    Users updateUser(Users users);
}
