package vids.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vids.spring.service.UserService;
import vids.spring.utils.UserPrincipal;
import vids.spring.model.Role;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    UserService userService;
    

    @PutMapping("change/{role}")////localhost:8080/api/user/change/{role}
    public ResponseEntity<?> changeRole(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable Role role){
         System.out.println("--------------------------33333333333333333333333333333");
       // System.out.println("--------------------------"+userPrincipal.getUsername()+" role");
            userService.updateRole(role, userPrincipal.getUsername());
            return ResponseEntity.ok(true);
    }
}
