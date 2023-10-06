package com.example.Challenge_4.Service;

import com.example.Challenge_4.Model.Users;
import com.example.Challenge_4.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService{
    private final UsersRepository usersRepository;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public  Users addUser(Users users) {
        return usersRepository.save(users);
    }
//    @Override
//    public Users addUser(Users users) {
//        return usersRepository.save(users);
//    }

    @Override
    public void deleteUser(String UserId) {
        usersRepository.deleteById(UserId);
    }

    @Override
    public Users updateUser(Users users) {
        return usersRepository.save(users);
    }
}
