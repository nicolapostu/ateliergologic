package com.gologicAPIRest.exemple.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RequestMapping("/api")
@RestController
public class UserController {

    @Autowired
    UserRepository userRepo ;
    @Autowired
    UserService userService ;

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User user){
        User userupdated = userService.update(id,user);

        try {
            return new ResponseEntity<>(userupdated, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        try {
            return new ResponseEntity<>(userRepo.save(user), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        Optional<User> user = userRepo.findById(id);

        if (user.isPresent()){
            return new ResponseEntity<>(user.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PatchMapping("/user/{id}")
    public ResponseEntity<User> patchedUser(@PathVariable Long id,@RequestBody User user){
        User userbyId = userService.patch(id, user.getCredit());
        try {
            return new ResponseEntity<>(userbyId, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
