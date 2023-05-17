package com.stackroute.springboot.contoller;

import com.stackroute.springboot.model.User;
import com.stackroute.springboot.service.UserService;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {
private UserService userService;
@Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
private static final Logger logger= LoggerFactory.getLogger(UserController.class);
    @GetMapping("/users")
    public ResponseEntity<List<User>>getAllUsers() {
        return new ResponseEntity<List<User>>((List<User>)userService.getAllUsers(),HttpStatus.OK);

    }
    @GetMapping("/messages")
    public String getmessages(){
        logger.info("this is info message");
        logger.info("this is debug message");
        logger.info("this is trace message");
        logger.info("this is warn message");
        logger.info("this is error message");
        return"sucessfull";
    }



@PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user){
    User savedUser=userService.saveUser(user);
    return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

}


    @PutMapping("/userss/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id,@RequestBody User user) throws Exception {
        user.setId(id);
        return ResponseEntity.ok().body(this.userService.updateUser(user));
    }
    @DeleteMapping("/usersss/{id}")
    public HttpStatus deleteUser(@PathVariable int id) throws Exception {
        this.userService.deleteUser(id);
        return HttpStatus.OK;
    }




}
