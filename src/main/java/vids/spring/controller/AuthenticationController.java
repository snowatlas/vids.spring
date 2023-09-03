package vids.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import vids.spring.model.User;
import vids.spring.service.AuthenticationService;
import vids.spring.service.UserService;

@RestController
@RequestMapping("api/authentication/")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    UserService userService;


    @PostMapping("sign-up")//localhost:8080/api/authentication/sign-up
    public ResponseEntity<?> signUp(@RequestBody User user ){

        if(userService.findUserByUsername(user.getUsername()).isPresent()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);

    }
    

    @PostMapping("sign-in")////localhost:8080/api/authentication/sign-in
    public ResponseEntity<?> signIn(@RequestBody User user){
        return new ResponseEntity<>(authenticationService.signeInAndReturnJwt(user),HttpStatus.OK);

    }


    
}
