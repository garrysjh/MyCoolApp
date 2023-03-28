package com.app.MyCoolApp.controllers;

import com.app.MyCoolApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserApiController {

    @Autowired
    UserService userService;
    @GetMapping("/test")
    public String testEndpoint(){
        return "Test end point is working";
    }
    //Section for registering

    @PostMapping("/user/register")
    public ResponseEntity registerNewUser(@RequestParam("username")String username,
                                          @RequestParam("password")String password,
                                          @RequestParam("firstname")String firstname,
                                          @RequestParam("lastname")String lastname,
                                          @RequestParam("mobile")String mobile){

        if(firstname.isEmpty() || lastname.isEmpty() || username.isEmpty() || password.isEmpty() || mobile.isEmpty()){
            return new ResponseEntity<>("Please complete all fields", HttpStatus.BAD_REQUEST);
        }
        //Register New User:
        int result = userService.registerNewUserServiceCall(username, password, firstname, lastname, mobile);

        if(result!=1){
            return new ResponseEntity<>("Failed to register", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("User registered successfully", HttpStatus.OK);
    }

}
