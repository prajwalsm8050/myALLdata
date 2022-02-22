package com.customer.demo.controller;

import com.customer.demo.customerRepo.UserRepo;
import com.customer.demo.model.User;
import com.customer.demo.serviceImpl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user/api/v1/")
@CrossOrigin(origins = "*")
public class UserController {


    @Autowired
    UserImpl userservices;

    @Autowired
    UserRepo userRepo;


    @GetMapping(value = "/getAll" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAllUSer() {
        return new ResponseEntity<List<User>>(userservices.listUser(), HttpStatus.CREATED);
    }



    @PostMapping(value = "/saveuser" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        userservices.saveUser(user);
        return new ResponseEntity<User>(user,HttpStatus.CREATED);
    }



    @DeleteMapping("/deleteUser/{id}")
    public List<User> deleteUser(@PathVariable long id) {
        userservices.deleteUser(id);
        return userservices.listUser();
    }



    @PutMapping("updateUser/{id}")
    public ResponseEntity<List<User>> updateUser(@PathVariable Long id , @RequestBody User user) {
        Optional<User> userOptional = userRepo.findById(id);
        if (!userOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        user.setId(id);
        userRepo.save(user);
        return  new ResponseEntity<List<User>>(userservices.listUser(), HttpStatus.CREATED);
    }


    @GetMapping("/getUser/{id}")
    public Optional<User> getUser(@PathVariable Long id)
    {
        return userRepo.findById(id);
    }

}
