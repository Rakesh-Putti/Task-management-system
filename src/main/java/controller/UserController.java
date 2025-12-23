package controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dto.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import service.UserService;
import util.ResponseStructure;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @Operation(summary = "Create User", description = "Admin creates a new user")
    @PostMapping("/create")
    public ResponseEntity<ResponseStructure<User>> createUser(@RequestBody User user,
            @RequestParam String currentRole) {
        return userService.saveUser(user, currentRole);
    }

    @Operation(summary = "Fetch User", description = "Fetch user by ID")
    @GetMapping("/{userId}")
    public ResponseEntity<ResponseStructure<User>> fetchUser(@PathVariable int userId) {
        return userService.fetchUserById(userId);
    }

    @Operation(summary = "Update User", description = "Admin updates user details")
    @PutMapping("/{userId}")
    public ResponseEntity<ResponseStructure<User>> updateUser(@PathVariable int userId,
            @RequestBody User newUser, @RequestParam String currentRole) {
        return userService.updateUser(userId, newUser, currentRole);
    }

    @Operation(summary = "Fetch All Users", description = "Fetch all users")
    @GetMapping("/all")
    public List<User> fetchAllUsers() {
        return userService.fetchAllUsers();
    }
}
