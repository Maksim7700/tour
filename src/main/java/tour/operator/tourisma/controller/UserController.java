package tour.operator.tourisma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tour.operator.tourisma.model.user.User;
import tour.operator.tourisma.service.UserService;

import javax.validation.Valid;
import java.util.List;

import static java.util.Objects.isNull;

@RestController
@Validated
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }
    
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
        
        return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
    }
    
    @PostMapping("/user")
    public ResponseEntity<String> addUser(@RequestBody @Valid User user) {
    
        userService.saveUser(user);
        return new ResponseEntity<>(user.toString(), HttpStatus.OK);
    }
    
    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Integer id) {
        
        User user = userService.findUserById(id);
        if (isNull(user)) {
            return new ResponseEntity<>("User not found", HttpStatus.OK);
        } else {
            userService.deleteUser(user);
            return new ResponseEntity<>("DELETE Response", HttpStatus.OK);
        }
    }
    
    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
    
        userService.userUpdate(id, user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
}
