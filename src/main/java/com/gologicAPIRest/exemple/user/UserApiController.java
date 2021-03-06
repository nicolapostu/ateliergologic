package com.gologicAPIRest.exemple.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RequestMapping("/user/api")
@CrossOrigin
@RestController
public class UserApiController {

    @Autowired
    UserService userService;

    @PutMapping("/{id}")
    public ResponseEntity<UserResource> updateUser(@PathVariable Long id,@RequestBody UserResource userResource){
        UserResource userUpdated = userService.update(id,userResource);

        try {
            return new ResponseEntity<>(userUpdated, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping(value = "")
    public ResponseEntity<UserResource> createUser(@RequestBody UserResource userResource){

        try {
          return new ResponseEntity<>(userService.create(userResource), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserResource> getUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.get(id),HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<UserResource> patchedUser(@PathVariable Long id,@RequestBody UpdateField updateField){
        try {
            return new ResponseEntity<>(userService.patch(id, updateField.getField(), updateField.getValue()) , HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResource> deletedUser(@PathVariable Long id ){
        try {
            return new ResponseEntity<>(userService.delete(id) , HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


