package service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dao.UserDao;
import dto.User;
import exception.UnauthorizedException;
import exception.UserNotFound;
import util.ResponseStructure;



@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    ResponseStructure<User> responseStructure;

    
    public ResponseEntity<ResponseStructure<User>> saveUser(User user, String currentRole) {
        if (!currentRole.equals("ADMIN")) {
            throw new UnauthorizedException("Only Admin can create users");
        }
        responseStructure.setStatusCode(HttpStatus.CREATED.value());
        responseStructure.setMessage("User created successfully");
        responseStructure.setData(userDao.saveUser(user));
        return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseStructure<User>> fetchUserById(int userId) {
        User user = userDao.fetchUserById(userId);
        if (user != null) {
            responseStructure.setStatusCode(HttpStatus.FOUND.value());
            responseStructure.setMessage("User fetched successfully");
            responseStructure.setData(user);
            return new ResponseEntity<>(responseStructure, HttpStatus.FOUND);
        } else {
            throw new UserNotFound();
        }
    }


    public ResponseEntity<ResponseStructure<User>> updateUser(int userId, User newUser, String currentRole) {
        if (!currentRole.equals("ADMIN")) {
            throw new UnauthorizedException("Only Admin can update users");
        }
        User user = userDao.fetchUserById(userId);
        if (user != null) {
            responseStructure.setStatusCode(HttpStatus.OK.value());
            responseStructure.setMessage("User updated successfully");
            responseStructure.setData(userDao.updateUserById(userId, newUser));
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        } else {
            throw new UserNotFound();
        }
    }

    
    public List<User> fetchAllUsers() {
        return userDao.fetchAllUsers();
    }

}

