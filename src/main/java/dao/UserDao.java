package dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dto.User;
import repo.UserRepo;


@Repository
public class UserDao {

    @Autowired
    UserRepo userRepo;

   
    public User saveUser(User user) {
        return userRepo.save(user);
    }

  
    public User fetchUserById(int userId) {
        return userRepo.findById(userId).get();
    }

   
    public User updateUserById(int oldUserId, User newUser) {
        newUser.setUserId(oldUserId);
        return userRepo.save(newUser);
    }

    public List<User> fetchAllUsers() {
        return userRepo.findAll();
    }

}

